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

package sadl.models.PTA;

import org.apache.commons.lang3.Range;

public class SubEventCriticalArea extends SubEvent {

	double enterProbability;
	int almostSurelyCount;

	public SubEventCriticalArea(Event event, int subEventNumber, double expectedValue, double deviation, Range<Double> boundInterval,
			Range<Double> anomalyInterval, Range<Double> warningInterval, double enterProbability) {
		super(event, subEventNumber, expectedValue, deviation, boundInterval, anomalyInterval, warningInterval);

		this.enterProbability = enterProbability;
		almostSurelyCount = (int) (Math.log(0.9999999999d) / Math.log(enterProbability));
	}

	public double getEnterProbability() {

		return enterProbability;
	}

	public int getAlmostSurelyCount() {

		return almostSurelyCount;
	}
}
