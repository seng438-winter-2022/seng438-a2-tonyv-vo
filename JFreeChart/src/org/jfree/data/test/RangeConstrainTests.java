package org.jfree.data.test;

import static org.junit.Assert.*;	

import org.jfree.data.Range;
import org.junit.*;


/*Constrain()
 * Returns the value within the range that is closest to the specified value.
 * 
 * value - double value 
 * 
 * Returns - the constrained value 
 * 
 * If value is farther left than left range limit, the left range limit is returned 
 * If value is farther right than right range limit, the right range limit is returned 
 * */
public class RangeConstrainTests{
	Range exRange;

	//Assume valid range is between -100,001 and 100,001
	//We do not use -Double.MAX_VALUE and Double.MAX_VALUE because any inputs would be out of bounds for the function
	@Before
	public void setUp() throws Exception {
		exRange = new Range(-100000, 100000); //sets range to b/w -100,000 and 100,000 for every test 
	}

	//This test checks whether any inputs closer to the right limit of the range will return the right range limit as the constrain value 
	@Test
	public void getConstrainValueOutsidePositiveEnd26() {
		assertEquals("The constrain value should be 100000", 100000 , exRange.constrain(100001), 0.00001d);
	}
	
	//This test checks whether any inputs closer to the left limit of the range will return the left range limit as the constrain value 
	@Test 
	public void getConstrainValueOutsideNegativeEnd27() {
		assertEquals("The constrain value should be -100000", -100000 , exRange.constrain(-100001), 0.00001d);
	}
	
	//This test checks whether any inputs that occur inside the range are also returned as the constrain value
	@Test 
	public void getConstrainValueFromWithinRange28() {
		assertEquals("The constrain value should be -100000", 0 , exRange.constrain(0), 0.00001d);
	}
	
	//Sets the Range object to null after every test 
	@After
	public void tearDown() throws Exception {
		exRange = null;
	}

}
