package stats;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import stats.RollingStats;

public class RollingStatsTest {
	
  @Test
  public void testAddValue() {
		int maxItems = 5;
	    RollingStats stats = new RollingStats(maxItems);
	    ArrayList<Double> values = new ArrayList<Double>(maxItems);
	    ArrayList<Double> expValues = new ArrayList<Double>(maxItems);
	    stats.AddValue(0.1, values, maxItems, -1);
	    stats.AddValue(2.4, values, maxItems, 0);
	    stats.AddValue(3.2, values, maxItems, 1);
	    stats.AddValue(1.5, values, maxItems, 2);
	    stats.AddValue(1.9, values, maxItems, 3);
	    expValues.add(0.1);
	    expValues.add(2.4);
	    expValues.add(3.2);
	    expValues.add(1.5);
	    expValues.add(1.9);
	    assertEquals("Incorrect values", expValues, values);
	  }

  @Test
  public void testGetMean() {
	int maxItems = 5;
    RollingStats stats = new RollingStats(maxItems);
    double expectedMean = (0.1+2.4+3.2+1.5+1.9)/5;
    ArrayList<Double> values = new ArrayList<Double>(maxItems);
    stats.AddValue(0.1, values, maxItems, -1);
    stats.AddValue(2.4, values, maxItems, 0);
    stats.AddValue(3.2, values, maxItems, 1);
    stats.AddValue(1.5, values, maxItems, 2);
    stats.AddValue(1.9, values, maxItems, 3);
    assertEquals("Incorrect mean", expectedMean, stats.getMean(values), 0);
  }
  
  @Test
  public void testGetMedian() {
	int maxItems = 5;
	RollingStats stats = new RollingStats(maxItems);
    ArrayList<Double> values = new ArrayList<Double>(maxItems);
    stats.AddValue(0.1, values, maxItems, -1);
    stats.AddValue(2.4, values, maxItems, 0);
    stats.AddValue(3.2, values, maxItems, 1);
    stats.AddValue(1.5, values, maxItems, 2);
    stats.AddValue(1.9, values, maxItems, 3);
    assertEquals("Incorrect median", 1.9, stats.getMedian(values), 0);
  }
  
  @Test
  public void testGetSum() {
	int maxItems = 5;
	RollingStats stats = new RollingStats(maxItems);
    double expectedSum = (0.1+2.4+3.2+1.5+1.9);
    ArrayList<Double> values = new ArrayList<Double>(maxItems);
    stats.AddValue(0.1, values, maxItems, -1);
    stats.AddValue(2.4, values, maxItems, 0);
    stats.AddValue(3.2, values, maxItems, 1);
    stats.AddValue(1.5, values, maxItems, 2);
    stats.AddValue(1.9, values, maxItems, 3);
    assertEquals("Incorrect sum", expectedSum, stats.getSum(values), 0);
  }
  
  @Test
  public void testGetStandardDeviation() {
	int maxItems = 5;
	RollingStats stats = new RollingStats(maxItems);
    ArrayList<Double> values = new ArrayList<Double>(maxItems);
    stats.AddValue(0.1, values, maxItems, -1);
    stats.AddValue(2.4, values, maxItems, 0);
    stats.AddValue(3.2, values, maxItems, 1);
    stats.AddValue(1.5, values, maxItems, 2);
    stats.AddValue(1.9, values, maxItems, 3);
    assertEquals("Incorrect standard deviation", 1.0303, stats.getStandardDeviation(values), 0);
  }
}
