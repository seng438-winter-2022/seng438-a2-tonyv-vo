package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeGetLengthTests {
	private Range rangeOne;
	private Range rangeTwo;
	private Range rangeThree;
	private Range rangeFour;
	private Range rangeFive;
	private Range rangeSix;
	
	/*
	 * This method sets rangeOne to a nominal and positive range.
	 */
	@Before
	public void setUpOne() throws Exception { 
		rangeOne = new Range(2.718, 6.28);
	}	
	
	/*
	 * This method sets rangeTwo to a range with a length of 0.
	 */
	@Before
	public void setUpTwo() throws Exception { 
		rangeTwo = new Range(5.0, 5.0);
	}
	
	/*
	 * This method sets rangeThree to a nominal and negative range.
	 */
	@Before
	public void setUpThree() throws Exception { 
		rangeThree = new Range(-7.0, -2.0);
	}
	
	/*
	 * This method sets rangeFour to a range where the bounds are at negative
	 * infinity to positive infinity.
	 */
	@Before
	public void setUpFour() throws Exception { 
		rangeFour = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	
	/*
	 * This method sets rangeFive to a range from beyond the lower permissible
	 * range for a Double to 0.
	 */
	@Before
	public void setUpFive() throws Exception { 
		rangeFive = new Range(-(1.01 * Double.MAX_VALUE), 0.0);
	}
	
	/*
	 * This method sets rangeSix to range from 0 to beyond the upper 
	 * permissible range for a Double.
	 */
	@Before
	public void setUpSix() throws Exception { 
		rangeSix = new Range(0.0, (1.01 * Double.MAX_VALUE));
	}
	
	/*
	 * Test case #16
	 * This test covers a nominal and positive range for the 
	 * lower and upper bound of the Range in the method getLength(), 
	 * which should result in a length of 3.56200
	 */
	@Test
	public void testNominalGetLength16() {
		assertEquals("The length of rangeOne should be 3.56200",
				3.56200, rangeOne.getLength(), .000000001d);
	}
	
	/*
	 * Test case #17
	 * This test covers a range with a length of 0 between the 
	 * lower and upper bound of the Range in the method getLength(), 
	 * which should result in a length of 0.0
	 */
	@Test
	public void testNominalGetLength17() {
		assertEquals("The length of rangeTwo should be zero",
		0.0, rangeTwo.getLength(), .000000001d);
	}
	
	/*
	 * Test case #18
	 * This test covers a nominal range for the lower and upper bound, 
	 * both of which are negative, of the Range in the method getLength(), 
	 * which should result in a length of 5.0
	 */
	@Test
	public void testNominalGetLength18() {
		assertEquals("The length of rangeThree should be 5",
		5.0, rangeThree.getLength(), .000000001d);
	}
	
	/*
	 * Test case #19
	 * This test covers a range of negative to positive infinity for the lower
	 * lower and upper bounds respectively in the method getLength(), 
	 * which should result in a length of positive infinity
	 */
	@Test
	public void testInfiniteBoundsGetLength19() {
		assertEquals("The length of rangeFour should be positive Infinity",
		Double.POSITIVE_INFINITY, rangeFour.getLength(), .000000001d);
	}
	
	/*
	 * Test case #20
	 * This test covers a range of beyond the lower bound of Double to 0.0 
	 * for the upper bound in the method getLength(), which should result 
	 * in a length of positive infinity due to overflow
	 */
	@Test
	public void testLowerBoundOutOfRangeGetLength20() {
		assertEquals("The length of rangeFive should be positive Infinity due to positive overflow",
		Double.POSITIVE_INFINITY, rangeFive.getLength(), .000000001d);
	}
	
	/*
	 * Test case #21
	 * This test covers a range of 0 to beyond the upper bound of Double
	 * in the method getLength(), which should result in a length of 
	 * positive infinity due to overflow
	 */
	@Test
	public void testUpperBoundOutOfRangeGetLength21() {
		assertEquals("The length of rangeSix should be positive Infinity due to positive overflow",
		Double.POSITIVE_INFINITY, rangeSix.getLength(), .000000001d);
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownOne() {
		rangeOne = null;
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownTwo() {
		rangeTwo = null;
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownThree() {
		rangeThree = null;
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownFour() {
		rangeFour = null;
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownFive() {
		rangeFive = null;
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownSix() {
		rangeSix = null;
	}
}
