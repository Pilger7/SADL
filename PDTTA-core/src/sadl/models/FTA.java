/**
 * This file is part of SADL, a library for learning all sorts of (timed) automata and performing sequence-based anomaly detection.
 * Copyright (C) 2013-2015  the original author or authors.
 *
 * SADL is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * SADL is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with SADL.  If not, see <http://www.gnu.org/licenses/>.
 */

package sadl.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.util.Pair;
import org.slf4j.Logger;

import gnu.trove.map.TIntDoubleMap;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TIntDoubleHashMap;
import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.stack.TIntStack;
import gnu.trove.stack.array.TIntArrayStack;
import sadl.input.TimedInput;
import sadl.input.TimedWord;
import sadl.structure.Transition;
import sadl.structure.ZeroProbTransition;

public class FTA {
	TObjectIntMap<Transition> transitionCount = new TObjectIntHashMap<>();

	TIntIntMap finalStateCount = new TIntIntHashMap(11, 0.75f, -1, -1);
	private final TimedInput input;
	private final Set<ZeroProbTransition> transitions = new HashSet<>();
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(FTA.class);
	int nextStateIndex = PDFA.START_STATE + 1;
	TIntStack determinizeStack = new TIntArrayStack();
	public FTA(TimedInput input) {
		this.input = input;
		for (final TimedWord word : input) {
			this.add(word);
		}
	}

	public Transition getTransition(int currentState, String event) {
		Transition result = null;
		if (event.equals(Transition.STOP_TRAVERSING_SYMBOL)) {
			result = getFinalTransition(currentState);
		} else {
			for (final Transition t : transitions) {
				if (t.getFromState() == currentState && t.getSymbol().equals(event)) {
					if (result != null) {
						logger.error("Found more than one transition for state " + currentState + " and event " + event);
					}
					result = t;
				}
			}
		}
		return result;
	}

	private void add(TimedWord word) {
		int currentState = PDFA.START_STATE;
		for (int i = 0; i < word.length(); i++) {
			final String symbol = word.getSymbol(i);
			Transition t = getTransition(currentState, symbol);
			if (t == null) {
				finalStateCount.put(nextStateIndex, 0);
				t = addTransition(currentState, nextStateIndex, symbol, 0);
				nextStateIndex++;
			}
			transitionCount.adjustOrPutValue(t.toZeroProbTransition(), 1, 1);
			currentState = t.getToState();
		}
		finalStateCount.adjustOrPutValue(currentState, 1, 1);
	}

	public Transition addTransition(int fromState, int toState, String symbol, double probability) {
		final Transition t = new Transition(fromState, toState, symbol, probability);
		transitions.add(t.toZeroProbTransition());
		return t;
	}

	/**
	 * Merges two states.
	 * 
	 * @param i
	 *            the first state to merge
	 * @param j
	 *            the second state to merge
	 */
	public void merge(int i, int j) {
		logger.debug("Merging state {} and {}", i, j);
		final Pair<List<Transition>, List<Transition>> inOutI = getInOutTransitions(i, false);
		final Pair<List<Transition>, List<Transition>> inOutJ = getInOutTransitions(j, false);
		final List<Transition> inTransitionsI = inOutI.getKey();
		final List<Transition> outTransitionsI = inOutI.getValue();
		final List<Transition> inTransitionsJ = inOutJ.getKey();
		final List<Transition> outTransitionsJ = inOutJ.getValue();

		int iOutCount = 0;
		for (final Transition t : outTransitionsI) {
			iOutCount += transitionCount.get(t.toZeroProbTransition());
		}
		iOutCount += finalStateCount.get(i);

		int jOutCount = 0;
		for (final Transition t : outTransitionsJ) {
			jOutCount += transitionCount.get(t.toZeroProbTransition());
		}
		jOutCount += finalStateCount.get(j);

		int iInCount = 0;
		for (final Transition t : inTransitionsI) {
			iInCount += transitionCount.get(t.toZeroProbTransition());
		}

		int jInCount = 0;
		for (final Transition t : inTransitionsJ) {
			jInCount += transitionCount.get(t.toZeroProbTransition());
		}
		// inputs from j will be inputs into i
		for (final Transition t : inTransitionsJ) {
			removeTransition(t);
			final int jCount = transitionCount.remove(t.toZeroProbTransition());
			final Transition newTrans = new Transition(t.getFromState(), i, t.getSymbol(), 0);
			addTransition(newTrans);
			transitionCount.adjustOrPutValue(newTrans.toZeroProbTransition(), jCount, jCount);
		}
		// outputs from j will be outputs from i
		for (final Transition t : outTransitionsJ) {
			removeTransition(t);
			final int jCount = transitionCount.remove(t.toZeroProbTransition());
			final Transition newTrans = new Transition(i, t.getToState(), t.getSymbol(), 0);
			addTransition(newTrans);
			transitionCount.adjustOrPutValue(newTrans.toZeroProbTransition(), jCount, jCount);
		}
		final int stopCount = finalStateCount.remove(j);
		finalStateCount.adjustOrPutValue(i, stopCount, stopCount);
		removeState(j);
		determinizeStack.push(i);
	}

	private void addTransition(Transition newTrans) {
		transitions.add(newTrans.toZeroProbTransition());

	}

	private void removeState(int j) {
		// also remove all transitions from and to state j (at this point there should be no more such transitions)
		for (final String symbol : getAlphabet().getSymbols()) {
			final List<Transition> transList = getTransitions(j, symbol);
			if (!transList.isEmpty()) {
				logger.error("Transition list not empty for state {} and symbol {}", j, symbol);
			}
		}
	}

	protected boolean removeTransition(Transition t) {
		final boolean wasRemoved = transitions.remove(t);
		if (!wasRemoved) {
			logger.warn("Tried to remove a non existing transition={}", t);
		}
		return wasRemoved;
	}


	public void determinize() {
		while (determinizeStack.size() != 0) {
			final int state = determinizeStack.pop();
			for (final String event : getAlphabet().getSymbols()) {
				final List<Transition> nonDetTransitions = getTransitions(state, event);
				Collections.sort(nonDetTransitions);
				if (nonDetTransitions.size() >= 2) {
					final int firstState = nonDetTransitions.get(0).getToState();
					logger.debug("Found {} outgoing transititions for state {} and symbol {}", nonDetTransitions.size(), state, event);
					for (int i = 1; i < nonDetTransitions.size(); i++) {
						final int secondState = nonDetTransitions.get(i).getToState();
						merge(firstState, secondState);
					}
				}
			}
		}

	}

	public TimedInput getAlphabet() {
		return input;
	}

	/**
	 * Returns all outgoing transitions for a given state
	 * 
	 * @param currentState
	 *            the given state
	 * @param includeStoppingTransition
	 *            whether to include final transition probabilities
	 * @return the outgoing transitions
	 */
	public Pair<List<Transition>, List<Transition>> getInOutTransitions(int currentState, boolean includeStoppingTransition) {
		final List<Transition> outTransitions = new ArrayList<>();
		final List<Transition> inTransitions = new ArrayList<>();

		for (final Transition t : transitions) {
			if (t.getFromState() == currentState) {
				outTransitions.add(t);
			}
			if (t.getToState() == currentState) {
				inTransitions.add(t);
			}
		}
		if (includeStoppingTransition) {
			for (final int state : finalStateCount.keys()) {
				if (state == currentState) {
					outTransitions.add(getFinalTransition(state));
				}
			}
		}
		return Pair.create(inTransitions, outTransitions);
	}

	protected Transition getFinalTransition(int state) {
		return new Transition(state, state, Transition.STOP_TRAVERSING_SYMBOL, 0);
	}

	protected List<Transition> getTransitions(int state, String event) {
		final List<Transition> result = new ArrayList<>();
		if (event.equals(Transition.STOP_TRAVERSING_SYMBOL)) {
			result.add(getFinalTransition(state));
		} else {
			for (final Transition t : transitions) {
				if (t.getFromState() == state && t.getSymbol().equals(event)) {
					result.add(t);
				}
			}
		}
		return result;
	}

	public PDFA toPdfa() {
		final Set<Transition> probTransitions = new HashSet<>();
		final TIntDoubleMap finalStateProbabilities = new TIntDoubleHashMap();
		final TIntIntMap stateOcurrenceCount = new TIntIntHashMap(finalStateCount.size());
		for (final Transition t : transitions) {
			final int value = transitionCount.get(t.toZeroProbTransition());
			stateOcurrenceCount.adjustOrPutValue(t.getFromState(), value, value);
		}
		for (final int state : finalStateCount.keys()) {
			final int value = finalStateCount.get(state);
			stateOcurrenceCount.adjustOrPutValue(state, value, value);
			final int stateVisits = stateOcurrenceCount.get(state);
			finalStateProbabilities.put(state, (double) finalStateCount.get(state) / stateVisits);

		}
		for (final Transition t : transitions) {
			final int stateVisits = stateOcurrenceCount.get(t.getFromState());
			final int transitionVisits = transitionCount.get(t.toZeroProbTransition());
			probTransitions.add(new Transition(t.getFromState(), t.getToState(), t.getSymbol(), (double) transitionVisits / stateVisits));
		}
		return new PDFA(getAlphabet(), probTransitions, finalStateProbabilities, null);
	}

	public int getStateCount() {
		return finalStateCount.size();
	}

	public int getTransitionCount(Transition transition) {
		return transitionCount.get(transition);
	}

	public Collection<ZeroProbTransition> getAllTransitions() {
		return transitions;
	}

	public int getFinalStateCount(int qu) {
		return finalStateCount.get(qu);
	}

	public TObjectIntMap<Transition> getTransitionCount() {
		return transitionCount;
	}

	public boolean containsState(int i) {
		return finalStateCount.containsKey(i);
	}
}
