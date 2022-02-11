package org.jfree.data.test;

import static org.junit.Assert.*;			
import org.jfree.data.Range;
import org.junit.*;

public class RangeGetUpperBoundTests 
{
	// getUpperBound(): test cases 1 - 7
	Range testRangeAboveMax;
	Range testRangeBelowMax;
	Range testRangeSame;
	Range testRangeAboveMin;
	Range testRangeBelowMin;
	Range testRangeOnMax;
	Range testRangeOnMin;
	
	// ************* Lower bound is set to 0 for test cases 1 - 5 involving getUpperRange(): ************
	
	// Above primitive double max value and above lower bound: invalid input since upper bound becomes positive infinity (overflow)
	// (Double.MAX_VALUE * 1.01) is above maximum value which is above maximum valid upper bound
	@Before
	public void setUp1() throws Exception 
	{	
		double aboveMax = (Double.MAX_VALUE * 1.01); // above max double value for a primitive double
		testRangeAboveMax = new Range(0.0, aboveMax); // upper bound is above max double value
	}
	
	@Test(timeout = 1000)
	public void testGetUpperBoundForAboveMaxDoubleValue1() // upper bound > max double value so overflow
	{
		double actualAboveMax = testRangeAboveMax.getUpperBound(); // return the upper bound value which should be above max value 
		double expectedAboveMax = Double.POSITIVE_INFINITY; // indicates overflow past maximum double value
		assertEquals("Checking that invalid upper bound above max causes positive overflow.", expectedAboveMax, actualAboveMax, .000000001d);
	}
	
	@After
	public void tearDown1()
	{
		testRangeAboveMax = null;
	}
	
	// Below primitive double max value and above lower bound: valid input since max >= upper bound > lower bound
	// Double.MAX_VALUE is the maximum valid upper bound
	@Before
	public void setUp2() throws Exception // upper bound is below maximum valid input and above lower bound
	{	
		double onMax = Double.MAX_VALUE; 
		testRangeOnMax = new Range(0.0, onMax); // upper bound is just below max double value
	}
	
	@Test(timeout = 1000)
	public void testGetUpperBoundForOnMaxDoubleValue2()
	{
		double actualOnMax = testRangeOnMax.getUpperBound(); // return the upper bound value which should be just below max value 
		double expectedOnMax = Double.MAX_VALUE;
		assertEquals("Value is tested for getting valid upper bound on max double value and above lower bound.", expectedOnMax, actualOnMax, .000000001d);
	}
	
	@After
	public void tearDown2()
	{
		testRangeOnMax = null;
	}
	
	// Below primitive double max value and above lower bound: valid input since max >= upper bound > lower bound
	// (Double.MAX_VALUE / 1.01) is below maximum upper bound and is valid
	@Before
	public void setUp3() throws Exception // upper bound is below maximum valid input and above lower bound
	{	
		double belowMax = (Double.MAX_VALUE / 1.01); 
		testRangeBelowMax = new Range(0.0, belowMax); // upper bound is just below max double value
	}
	
	@Test(timeout = 1000)
	public void testGetUpperBoundForBelowMaxDoubleValue3()
	{
		double actualBelowMax = testRangeBelowMax.getUpperBound(); // return the upper bound value which should be just below max value 
		double expectedBelowMax = (Double.MAX_VALUE / 1.01);
		assertEquals("Value is tested for getting valid upper bound below max double value and above lower bound.", expectedBelowMax, actualBelowMax, .000000001d);
	}
	
	@After
	public void tearDown3()
	{
		testRangeBelowMax = null;
	}
	
	// Same value as lower bound: should pass since upper bound = lower bound
	// 0.0 is valid upper bound and is half way within valid range
	@Before
	public void setUp4() throws Exception 
	{	
		double sameValue = 0.0;
		testRangeSame = new Range(0.0, sameValue); // 0 is set as lower bound and 0 is upper bound
	}
	
	@Test(timeout = 1000)
	public void testGetUpperBoundSameValue4()
	{
		double actualSameValue = testRangeSame.getUpperBound(); // return the upper bound value which should be same as lower bound value 
		assertEquals("Same value of lower bound and upper bound is tested and is valid input.", 0.0, actualSameValue, .000000001d);
	}
	
	@After
	public void tearDown4()
	{
		testRangeSame = null;
	}
	
	// Above minimum double value and below lower bound: should pass since throws exception where upper bound < lower bound so illegal args
	// -(Double.MAX_VALUE / 1.01) is above minimum upper bound but is invalid since illegal arg for Range inputs
	@Test(expected = IllegalArgumentException.class)
	public void testAboveMinValueForGetUpperBound5()
	{
		double aboveMin = -(Double.MAX_VALUE / 1.01); // above minimum double value for a primitive double 
		testRangeAboveMin = new Range(0, aboveMin); // throws exception here since illegal args for Range inputs
		testRangeAboveMin.getUpperBound(); // method throws exception
	}
	
	// -Double.MAX_VALUE is on minimum upper bound but is invalid since illegal arg since lower bound > upper bound
	@Test(expected = IllegalArgumentException.class)
	public void testGetUpperBoundForOnMinDoubleValue6()
	{
		double onMin = -Double.MAX_VALUE; 
		testRangeOnMin = new Range(0.0, onMin); // upper bound is on min double value
		testRangeOnMin.getUpperBound(); // method throws exception since lower bound > upper bound
	}
	
	// Below minimum double value and below lower bound: should pass since throws exception where upper bound < lower bound 
	// -(Double.MAX_VALUE * 1.01) is below minimum value and is invalid but throws exception since upper bound < lower bound
	@Test(expected = IllegalArgumentException.class)
	public void testBelowMinValueForGetUpperBound7()
	{
		double belowMin = -(Double.MAX_VALUE * 1.01); // below minimum double value for a primitive double
		testRangeBelowMin = new Range(0, belowMin); // throws illegal args exception here since 
		testRangeBelowMin.getUpperBound(); // method throws exception
	}
	
}
