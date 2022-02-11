package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.*;

/*
 * Constructs an array of arrays of Number objects from 
 * a corresponding structure containing double primitives.
 * 
 * Parameters: double [][] data 
 * null is not permitted 
 * 
 * Returns an array of Double
 * 
 * 
 * */
public class DataUtilitiesCreateNumberArray2DTests extends DataUtilities {

	//IllegalArgumentException is a class that is thrown to indicate that a method has been passed an illegal or inappropriate argument. 
	//This test checks if createNumberArray2D() identifies the null array as an illegal input
	@Test(expected = IllegalArgumentException.class)
	public void checkNullNotPermitted24() {
		double[][] data = null; //data 2D array is set to null
		DataUtilities.createNumberArray2D(data); //createNumberArray2D() is sent a null array 
	}
	
	//This test checks if createNumberArray2D() turns a 2d double array into a 2d Number  array 
	@Test 
	public void checkArrayConstructed25() {
		double [][] inp =  { { 1.34, 2.66}, { 3.14, 4.98, 5.66}, {9.33, 6.77, 2.22} }; //2d double array input
		Number [][] exp = { { 1.34, 2.66}, { 3.14, 4.98, 5.66}, {9.33, 6.77, 2.22} }; //2d expected output of createNumberArray2D()
		
		Number [][] res = DataUtilities.createNumberArray2D(inp); //calling of createNumberArray2D() with 2d input array as parameter
		
		assertArrayEquals("exp should equal res", exp, res); //assert checks if the expected result is the same as the actual result of calling the function
		
	}

}
