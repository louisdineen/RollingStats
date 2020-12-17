package stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RollingStats {
	private int maxItems;
	private double mean;
	private double median;
	private double sum;
	private double standardDeviation;
	List<Double> values = new ArrayList<>();

	public RollingStats(int maxItems) {
		this.maxItems = maxItems;
	}
	
	public void AddValue(double value, List<Double> values, int maxItems, int rotatingIndex) {
		rotatingIndex = (rotatingIndex + 1)%maxItems;
	    values.add(rotatingIndex,value);
	}
	
	public double getMean(List<Double> values) {
		double total = 0.0;
		for(int i = 0; i < values.size(); i++){
			total += values.get(i);
		}
		mean = total/values.size();
		return mean;
	}
	
	public double getMedian(List<Double> values) {
		Collections.sort(values);
	        if (values.size()%2 == 1) {
	        	median = values.get(Math.round(values.size()/2));
	        } else {
	        	median = (values.get(values.size()/2) + values.get(values.size()/2 + 1))/2;
	        }
		return median;
	}
	
	public double getSum(List<Double> values) {
		for(int i = 0; i < values.size(); i++){
			sum += values.get(i);
		} 
		return sum;
	}
	
	public double getStandardDeviation(List<Double> values){
		double mean = getMean(values);
	    double temp = 0;
	    for (int i = 0; i < values.size(); i++){
	        double val = values.get(i);
	        double squrDiffToMean = Math.pow(val-mean, 2);
	        temp += squrDiffToMean;
	    }
	    double meanOfDiffs = temp/values.size();
	    standardDeviation = Math.round(10000.0*Math.sqrt(meanOfDiffs))/10000.0;
		return standardDeviation;
	}
}