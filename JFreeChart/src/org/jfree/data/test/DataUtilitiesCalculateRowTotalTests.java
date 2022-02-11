package org.jfree.data.test;

import static org.junit.Assert.*;								
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class DataUtilitiesCalculateRowTotalTests 
{
	// ********** Assume 1 - 10 columns and rows for test cases #8 - 11: *******************
	// ********** Row total ranges in between maximum and minimum double values: **********
	
	// tests input in regards to being above maximum sum of values data in row 0 which causes positive overflow (invalid range)
	@Test(timeout = 1000)
	public void testCalculateRowTotalForTwoValuesAboveMaxValue8()
	{
		Mockery mockingContext = new Mockery(); // new mock object without context
		final Values2D values = mockingContext.mock(Values2D.class); // mocking Values2D object for context
		mockingContext.checking(new Expectations() {{
		  	one(values).getColumnCount(); // # of columns in table: invokes the method once with one() with mock object inside
            will(returnValue(2)); // 3 columns in table: will return the value (2) to the caller which is mock object
            one(values).getValue(0, 0); // get value from table at point (0,0)
            will(returnValue(Double.MAX_VALUE)); //
            one(values).getValue(0, 1);
            will(returnValue(Double.MAX_VALUE));
	}});
	double expectedRowSum = DataUtilities.calculateRowTotal(values, 0);
	double actualRowSum = Double.POSITIVE_INFINITY;
	mockingContext.assertIsSatisfied();
    assertEquals("Checking that the row total has positive overflow", expectedRowSum, actualRowSum, .000000001d);
	}
	
	// tests input within valid range in regards to the sum of values data in row 1
	@Test(timeout = 1000)
	public void testCalculateRowTotalForFiveValuesRowOne9()
	{
		Mockery mockingContext = new Mockery(); // new mock object without context
		final Values2D values = mockingContext.mock(Values2D.class); // mocking Values2D object for context
		mockingContext.checking(new Expectations() {{
		  	one(values).getColumnCount(); // # of columns in table: invokes the method once one() with mock object inside
            will(returnValue(5)); // 5 columns in table: will return the value (5) to the caller which is mock object
            one(values).getValue(1, 0); // get value from table at point (1,0)
            will(returnValue(10.0)); //
            one(values).getValue(1, 1);
            will(returnValue(5.0));
            one(values).getValue(1, 2);
            will(returnValue(5.0));
            one(values).getValue(1, 3);
            will(returnValue(5.0));
            one(values).getValue(1, 4);
            will(returnValue(5.0));
	}});
	double expectedRowSum = DataUtilities.calculateRowTotal(values, 1);
	mockingContext.assertIsSatisfied();
    assertEquals("Checking that the row total in row 1 is correct.", expectedRowSum, 30.0, .000000001d);
	}
	
	// tests input below minimum sum of values data in row 0 which causes negative overflow (invalid range)
	@Test(timeout = 1000)
	public void testCalculateRowTotalForTwoValuesBelowMinValue10()
	{
		Mockery mockingContext = new Mockery(); // new mock object without context
		final Values2D values = mockingContext.mock(Values2D.class); // mocking Values2D object for context
		mockingContext.checking(new Expectations() {{
		  	one(values).getColumnCount(); // # of columns in table: invokes the method once one() with mock object inside
            will(returnValue(2)); // 3 columns in table: will return the value (2) to the caller which is mock object
            one(values).getValue(0, 0); // get value from table at point (0,0)
            will(returnValue(-Double.MAX_VALUE)); //
            one(values).getValue(0, 1);
            will(returnValue(-Double.MAX_VALUE));
	}});
	double expectedRowSum = DataUtilities.calculateRowTotal(values, 0);
	double actualRowSum = Double.NEGATIVE_INFINITY;
	mockingContext.assertIsSatisfied();
    assertEquals("Checking that the row total has negative overflow", expectedRowSum, actualRowSum, .000000001d);
	}
	
	// test that throws exception when data in Values2D interface is null
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowWhereDataIsNull11()
	{
		final Values2D values = null;
		DataUtilities.calculateRowTotal(values, 0); // illegal args exception is thrown here
	}
}
