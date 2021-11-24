package test;

import java.util.ArrayList;
import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {


	@Override
	public void learnNormal(TimeSeries ts) {
		int i=0;
		int [] ListSize= new int[ts.arrTimeSeries.size()];

	}

	@Override
	public List<AnomalyReport> detect(TimeSeries ts) {
		return null;
	}

	public List<CorrelatedFeatures> getNormalModel() {
		return null;
	}
	private float [] ListToArray(ArrayList ) {

		return new float[0];
	}

}
