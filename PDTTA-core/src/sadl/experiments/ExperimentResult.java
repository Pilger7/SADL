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

package sadl.experiments;

import sadl.constants.AnomalyInsertionType;
import sadl.constants.MergeTest;
import sadl.constants.ProbabilityAggregationMethod;


/**
 * 
 * @author Timo Klerx
 *
 */
public class ExperimentResult {

	public ExperimentResult(int truePositives, int trueNegatives, int falsePositives, int falseNegatives) {
		super();
		this.truePositives = truePositives;
		this.trueNegatives = trueNegatives;
		this.falsePositives = falsePositives;
		this.falseNegatives = falseNegatives;
		precision = (double) truePositives / (truePositives + falsePositives);
		recall = (double) truePositives / (truePositives + falseNegatives);
	}
	double precision;
	double recall;
	double fMeasure;
	int truePositives;
	int trueNegatives;
	int falsePositives;
	int falseNegatives;
	boolean recMergeTest;
	double mergeAlpha;
	AnomalyInsertionType anomalyInsertionType;

	public AnomalyInsertionType getAnomalyInsertionType() {
		return anomalyInsertionType;
	}

	public void setAnomalyInsertionType(AnomalyInsertionType anomalyInsertionType) {
		this.anomalyInsertionType = anomalyInsertionType;
	}


	@Override
	public String toString() {
		return "PdttaExperimentResult [precision=" + precision + ", recall=" + recall + ", fMeasure=" + fMeasure
				+ ", truePositives=" + truePositives + ", trueNegatives=" + trueNegatives + ", falsePositives=" + falsePositives + ", falseNegatives="
				+ falseNegatives + ", recMergeTest=" + recMergeTest + ", mergeAlpha=" + mergeAlpha + ", anomalyInsertionType=" + anomalyInsertionType
				+ ", mergeTest=" + mergeTest + ", timeTreshold=" + timeThreshold + ", eventTreshold=" + eventThreshold + ", aggType=" + aggType + "]";
	}
	MergeTest mergeTest;
	double timeThreshold;
	double eventThreshold;
	ProbabilityAggregationMethod aggType;

	public ExperimentResult(double precision, double recall, double fMeasure, int truePositives, int trueNegatives,
			int falsePositives, int falseNegatives, boolean recMergeTest, double mergeAlpha, MergeTest mergeTest, double timeTreshold, double eventTreshold,
			ProbabilityAggregationMethod aggType, AnomalyInsertionType anomalyInsertionType) {
		this(truePositives, trueNegatives, falsePositives, falseNegatives);
		this.precision = precision;
		this.recall = recall;
		this.fMeasure = fMeasure;
		this.recMergeTest = recMergeTest;
		this.mergeAlpha = mergeAlpha;
		this.mergeTest = mergeTest;
		this.timeThreshold = timeTreshold;
		this.eventThreshold = eventTreshold;
		this.aggType = aggType;
		this.anomalyInsertionType = anomalyInsertionType;
	}


	public double getPrecision() {
		return precision;
	}

	public double getRecall() {
		return recall;
	}

	public double getFMeasure() {
		final double result = 2 * precision * recall / (precision + recall);
		if (Double.isNaN(result)) {
			return 0;
		}
		return result;
	}

	public int getTruePositives() {
		return truePositives;
	}

	public int getTrueNegatives() {
		return trueNegatives;
	}

	public int getFalsePositives() {
		return falsePositives;
	}

	public int getFalseNegatives() {
		return falseNegatives;
	}

	public boolean isRecMergeTest() {
		return recMergeTest;
	}

	public double getMergeAlpha() {
		return mergeAlpha;
	}

	public MergeTest getMergeTest() {
		return mergeTest;
	}

	public double getTimeTreshold() {
		return timeThreshold;
	}

	public double getEventTreshold() {
		return eventThreshold;
	}

	public ProbabilityAggregationMethod getAggType() {
		return aggType;
	}

	public void setRecMergeTest(boolean recMergeTest) {
		this.recMergeTest = recMergeTest;
	}

	public void setMergeAlpha(double mergeAlpha) {
		this.mergeAlpha = mergeAlpha;
	}

	public void setMergeTest(MergeTest mergeTest) {
		this.mergeTest = mergeTest;
	}

	public void setTimeThreshold(double timeThreshold) {
		this.timeThreshold = timeThreshold;
	}

	public void setEventThreshold(double eventThreshold) {
		this.eventThreshold = eventThreshold;
	}

	public void setAggType(ProbabilityAggregationMethod aggType) {
		this.aggType = aggType;
	}

	static String separator = ";";

	public static String CsvHeader() {
		return "precision" + separator + "recall" + separator + "fMeasure" + separator + "truePositives" + separator
				+ "trueNegatives" + separator + "falsePositives" + separator + "falseNegatives" + separator + "recMergeTest" + separator + "mergeAlpha"
				+ separator + "anomalyInsertionType" + separator + "mergeTest" + separator + "timeTreshold" + separator + "eventTreshold" + separator
				+ "aggType";
	}
	public String toCsvString() {
		return precision + separator + recall + separator + fMeasure + separator + truePositives + separator + trueNegatives
				+ separator + falsePositives + separator + falseNegatives + separator + recMergeTest + separator + mergeAlpha + separator
				+ anomalyInsertionType + separator + mergeTest + separator + timeThreshold + separator + eventThreshold + separator + aggType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fMeasure);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ExperimentResult other = (ExperimentResult) obj;
		if (Double.doubleToLongBits(fMeasure) != Double.doubleToLongBits(other.fMeasure)) {
			return false;
		}
		return true;
	}

	public double getPhiCoefficient() {
		final double numerator = truePositives * trueNegatives - falsePositives * falseNegatives;
		final double denominator = Math.sqrt(
				(truePositives + falsePositives) * (truePositives + falseNegatives) * (trueNegatives + falsePositives) * (trueNegatives + falseNegatives));
		return numerator / denominator;
	}

	public double getAccuracy() {
		return (double) truePositives + trueNegatives / (truePositives + trueNegatives + falsePositives + falseNegatives);
	}

}
