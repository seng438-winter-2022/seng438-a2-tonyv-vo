package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.*;

public class DataUtilitiesCreateNumberArrayTests extends DataUtilities {
	
	/*
	 * Test case #22
	 * This test covers a null double array for the data argument
	 * in method createNumberArray(), which should result in an 
	 * IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayNullData22() {
		Number[] expected = null;
		double[] data = null;
		Number[] result = DataUtilities.createNumberArray(data);
		// Should not run due to IllegalArgumentException being thrown after the line above
		assertArrayEquals(expected, result);
	}
	
	/*
	 * Test case #23
	 * This test covers a valid (i.e. non-null) double array for the data 
	 * argument in method createNumberArray(), which should result in a 
	 * Number[] containing the same values as in the data array argument
	 */
	@Test
	public void testCreateNumberArrayValidData23() {
		Number expected[] = {1.23, 3.21, 3.14159, 9.81};
		
		double[] data = {1.23, 3.21, 3.14159, 9.81};
		Number[] result = DataUtilities.createNumberArray(data);
		assertArrayEquals("Checking that result from createNumberArray() is equal to predefined value.", expected, result);
	}

}
