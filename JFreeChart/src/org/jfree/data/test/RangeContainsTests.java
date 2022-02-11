package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeContainsTests 
{
	// contains(): test cases 12 - 15
	Range testMinMaxRange;
	Range testSameRange;
	
	// *************** The following is test cases 12 - 15 for contains(): **************
	
	// sets the valid range in between min and max double values for tests 12-14
	@Before 
	public void setup12_13_14()
	{
		testMinMaxRange = new Range(-(Double.MAX_VALUE), Double.MAX_VALUE); // min and max valid range
	}
	
	// tests input value in the middle of the valid range which is 0.0 and is between min and max double values
	@Test(timeout = 1000)
	public void testMiddleValueBetweenMaxAndMin12()
	{
		boolean expected = true;
		boolean actual = testMinMaxRange.contains(0.0);
		assertEquals("value is halfway within min and max double values", expected, actual);
	}
	
	// tests input value below minimum causing negative overflow
	@Test(timeout = 1000)
	public void testValueLowerThanMin13()
	{
		boolean expected = false;
		boolean actual = testMinMaxRange.contains(-(Double.MAX_VALUE) - Double.MAX_VALUE);
		assertEquals("Invalid value that is lower than min and is outside of min and max double range", expected, actual);
	}
	
	// tests input value above maximum causing positive overflow
	@Test(timeout = 1000)
	public void testValueHigherThanMax14()
	{
		boolean expected = false;
		boolean actual = testMinMaxRange.contains(Double.MAX_VALUE + Double.MAX_VALUE);
		assertEquals("Invalid value that is higher than max and is outside of min and max double range", expected, actual);
	}
	
	// sets range to be the same value for test 15
	@Before 
	public void setup15()
	{
		testMinMaxRange = new Range(10.0, 10.0);
	}
	
	// tests input value to be the same as upper and lower bound
	@Test(timeout = 1000)
	public void testSameValueAsBothUpperAndLowerBounds15()
	{
		boolean expected = true;
		boolean actual = testMinMaxRange.contains(10.0);
		assertEquals("Valid as the value is the same value as upper and lower bounds", expected, actual);
	}
}
