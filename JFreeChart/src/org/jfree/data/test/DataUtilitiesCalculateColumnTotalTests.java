package org.jfree.data.test;

import static org.junit.Assert.*;							
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;


/**
 * 
 * @author chace
 * test class for DataUtilities.calculateColumnTotal in DataUtilities class
 * uses mocking for simulate Values2D class return values
 */
public class DataUtilitiesCalculateColumnTotalTests {

	//tests 42 - 45  are for calculateColumnTotal(Values2D data, int column) method in Class DataUtilities
	
	
	/**
	 * Test 42
	 * Uses mocking to input a 2D array containing values that stay in appropriate range
	 * 
	 */
	@Test(timeout = 1000) // timer
	public void testCalculateColumnTotalForFourValues42(){
		//need a mock for Values2D tables
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class); // values is valriable to use in mock
		
		mockingContext.checking(new Expectations() {{ // create a mock to use for Values2D
		  	one(values).getRowCount(); 
		  		will(returnValue(4)); // setting how many rows 
		  		
            one(values).getValue(0, 2);  // set values that values(0,2) will return)
            	will(returnValue( 10.0 )); 
            one(values).getValue(1, 2);
            	will(returnValue(  32.0  ));
            one(values).getValue(2, 2);
            	will(returnValue(  9.0   ));
            one(values).getValue(3, 2);
            	will(returnValue(  6.0 ));
		}});
		
		
		double expectedSum = 57.0;
		double actualSum = DataUtilities.calculateColumnTotal(values, 2); //call function using mock
		mockingContext.assertIsSatisfied();
	    assertEquals("Checking that fucntion returns correct sum", expectedSum, actualSum, .000000001d);
	}
	
	
	
	
	
	
	/**
	 * Test 43
	 * Boundary case using the max doubles added together to cause
	 *  overflow checking illegal arguments
	 */
	@Test(timeout = 1000) // timer
	public void testCalculateColumnTotalForThreeValuesAboveMaxValue43(){
		//need a mock for Values2D tables
		Mockery mockingContext = new Mockery(); // new mock object without context
		final Values2D values = mockingContext.mock(Values2D.class); // mocking Values2D object for context
		
		mockingContext.checking(new Expectations() {{ // setting up mock 
		  	one(values).getRowCount(); 
            will(returnValue(3));  // setting how many rows 
           
            one(values).getValue(0, 0); // get value from table at point (0,0)
            will(returnValue(Double.MAX_VALUE)); // its return value
            one(values).getValue(1, 0);
            will(returnValue(Double.MAX_VALUE));
            one(values).getValue(2, 0);
            will(returnValue(Double.MAX_VALUE));
		}});
		
		double expectedSum = Double.POSITIVE_INFINITY;
		double actualSum = DataUtilities.calculateColumnTotal(values, 0); //call function using mock
		mockingContext.assertIsSatisfied();
	    assertEquals("Checking that the column total is an overflow", expectedSum, actualSum, .000000001d);
	}
	
	
	
	
	/**
	 * Test 44
	 * for max negative numbers in each section of a column giving an overflow error
	 * the opposite of test 41
	 */
	@Test(timeout = 1000) // timer
	public void testCalculateColumnTotalForThreeValuesBelowMinValue44(){
		//need a mock for Values2D tables
		Mockery mockingContext = new Mockery(); // new mock object without context
		final Values2D values = mockingContext.mock(Values2D.class); // mocking Values2D object for context
		
		mockingContext.checking(new Expectations() {{ // setting up mock
		  	one(values).getRowCount();
            will(returnValue(3)); // setting how many rows 
            
            one(values).getValue(0, 1); // get value from table at point (0,1)
            will(returnValue(-Double.MAX_VALUE)); // value to use for  [0,1]
            one(values).getValue(1, 1);
            will(returnValue(-Double.MAX_VALUE));
            one(values).getValue(2, 1);
            will(returnValue(-Double.MAX_VALUE));
		}});
		
		double expectedSum = Double.NEGATIVE_INFINITY;
		double actualSum = DataUtilities.calculateColumnTotal(values, 1); // call function using mock
		mockingContext.assertIsSatisfied();
	    assertEquals("Checking that the column total is an overflow", expectedSum, actualSum, .000000001d);
	}

	
	
	
	/**
	 * Test 45
	 * Test to check special illegal argument 
	 * if Value2d argument is null and passed to calculateColumnTotal
	 */
	@Test(expected = IllegalArgumentException.class) // expecting an exception
	public void testCalculateColumnWithNulldata45(){
		final Values2D values = null; // values is null
		DataUtilities.calculateColumnTotal(values, 0); // illegal args exception is thrown here
	}
	
	
	
}//end test class
