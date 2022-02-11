package org.jfree.data.test;

import static org.junit.Assert.*;			
import org.jfree.data.Range;
import org.junit.*;



/**
 * 
 * @author chace
 *	Class to test the getLowerBound() Method of the Range class
 */
public class RangeGetLowerBoundTests {

	// getLowerBound() method tested
	// Range fields to be used in tests
	private Range lowerBoundBelowMaxNegative;// for extreme negative boundary tests
	private Range lowerBoundAtMaxNegative;
	private Range lowerBoundaboveMaxNegative;
	
	private Range lowerBoundInSimpleRange; // for middle of range test
	
	private Range lowerBoundBelowMaxValue; // for extreme positive boundary tests
	private Range lowerBoundAtMaxValue;
	private Range lowerBoundAboveMaxValue;
	
	private Range lowerBoundAboveUpper; // for exception test
	
	
	//test numbers relate to the test Design document list

	/**
	 * Test 27
	 * Lowerbound of the range in below the max negative a double can allow
	 * checks boundary with a response to illegal parameter
	 * @throws Exception
	 */
	@Before
	public void setUp27() throws Exception {	
		double lowerValue = (-Double.MAX_VALUE * 1.01); // number less than the min doulbe value
		lowerBoundBelowMaxNegative = new Range(lowerValue, 0.0); // lower bound is below min double value upper bound is 0.0
	}
	@Test(timeout = 1000) // a timeout of 1000
	public void testGetLowerBoundBelowMaxNegative27(){ 
		double actualLowerBound = lowerBoundBelowMaxNegative.getLowerBound(); // return the upper lower value which should be above max value 
		double expectedlowerBound = Double.NEGATIVE_INFINITY; // indicates overflow below maximum  negative double value
		assertEquals("Checking that invalid lower limit causes overflow ", expectedlowerBound, actualLowerBound, .000000001d); // assert equals 
	}
	@After
	public void tearDown1(){
		lowerBoundBelowMaxNegative = null; // tear down range
	}
	


	
	/**
	 * Test 28
	 * Lowerbound of the range in at the max negative a double can allow
	 * checks boundary with a response to max negative parameter on boundary line
	 * @throws Exception
	 */
	@Before
	public void setUp28() throws Exception {	
		double lowerValue = (-Double.MAX_VALUE); // number less at the min doule value
		lowerBoundAtMaxNegative = new Range(lowerValue, 0.0); // lower bound is at min double value upper bound is 0.0
	}
	@Test(timeout = 1000) // a timeout of 1000
	public void testGetLowerBoundAtMaxNegative28(){ 
		double actualLowerBound = lowerBoundAtMaxNegative.getLowerBound(); // return the lower bound value 
		double expectedlowerBound = -Double.MAX_VALUE; // indicates overflow past maximum negative double value
		assertEquals("Checking that lowerbound it at the largest negative value for a double ", expectedlowerBound, actualLowerBound, .000000001d); // assert equals
	}

	@After
	public void tearDown28(){
		lowerBoundAtMaxNegative = null; // tear down range
	}
	
	
	


	/**
	 * Test 29
	 * Lowerbound of the range in at the above negative a double can allow
	 * checks boundary with a response to near max negative parameter on boundary 
	 * line on legal side of boundary line
	 * @throws Exception
	 */
	@Before
	public void setUp29() throws Exception {	
		double lowerValue = (-Double.MAX_VALUE*0.99); // number less than the min doule value
		lowerBoundaboveMaxNegative = new Range(lowerValue, 0.0); // lower bound is below min double value upper bound is 0/0
	}
	@Test(timeout = 1000) // a timeout of 1000
	public void testGetLowerBoundAboveMaxNegative29(){ // upper bound > max double value so overflow
		double actualLowerBound = lowerBoundaboveMaxNegative.getLowerBound(); // return the upper bound value which should be above max value 
		double expectedlowerBound = -Double.MAX_VALUE*0.99; // indicates overflow past maximum double value
		assertEquals("Checking that lowerbound is just above the max negative double", expectedlowerBound, actualLowerBound, .000000001d); // assert equals
	}
	@After
	public void tearDown29(){
		lowerBoundaboveMaxNegative = null; // tear down range
	}
	

	
	

	/**
	 * Test 30
	 * Lowerbound of the range checking for range 0 - 0
	 * checks condition that is in middle of legal range values 
	 * @throws Exception
	 */
	@Before
	public void setUp30() throws Exception {	
		double lowerValue = (0); // number less than the min doule value
		lowerBoundInSimpleRange = new Range(lowerValue, 0.0); // lower bound is below min double value upper bound is 0.0
	}
	@Test(timeout = 1000) // a timeout of 1000
	public void testGetLowerBoundInSimpleRange30(){ 
		double actualLowerBound = lowerBoundInSimpleRange.getLowerBound(); // return the lower bound value which should be at 0 
		double expectedlowerBound = 0.0; // indicates overflow past maximum double value
		assertEquals("Checking that lowerbound is in a simple range at zero", expectedlowerBound, actualLowerBound, .000000001d); // assert equals
	}
	@After
	public void tearDown30(){
		lowerBoundInSimpleRange = null; // tear down range
	}
	



	
	/**
	 * Test 31
	 * Lowerbound is below max double allowed
	 * checks boundary case right beside max argument line
	 * @throws Exception
	 */
	@Before
	public void setUp31() throws Exception {	
		double lowerValue = (Double.MAX_VALUE*0.99); // number less than the min double value
		lowerBoundBelowMaxValue = new Range(lowerValue, Double.POSITIVE_INFINITY); // lower bound is below min double value //upper bound is at infinity
	}
	@Test(timeout = 1000) // a timeout of 1000
	public void testGetLowerBoundBelowMaxValue31(){ 
		double actualLowerBound = lowerBoundBelowMaxValue.getLowerBound(); // return the lower bound value which should be below max value 
		double expectedlowerBound = Double.MAX_VALUE*0.99; // indicates overflow past maximum double value
		assertEquals("Checking valid lower bound below max value", expectedlowerBound, actualLowerBound, .000000001d); // assert equals
	}
	@After
	public void tearDown31(){
		lowerBoundBelowMaxValue = null; // tear down range
	}
	
	
	
	
	
	/**
	 * Test 32
	 * Lowerbound is at max double allowed
	 * checks boundary case right on max argument line
	 * @throws Exception
	 */
	@Before
	public void setUp32() throws Exception {	
		double lowerValue = (Double.MAX_VALUE); // number less than the min doule value
		lowerBoundAtMaxValue = new Range(lowerValue, Double.POSITIVE_INFINITY); // lower bound is below min double value//upper bound is at infinity
	}
	@Test(timeout = 1000) // a timeout of 1000
	public void testGetLowerBoundAtMaxValue32(){ 
		double actualLowerBound = lowerBoundAtMaxValue.getLowerBound(); // return the lower bound value which should be at max value 
		double expectedlowerBound = Double.MAX_VALUE; // indicates overflow past maximum double value
		assertEquals("Checking that lower bound is at max double value ", expectedlowerBound, actualLowerBound, .000000001d); // assert equals
	}
	@After
	public void tearDown32(){
		lowerBoundAtMaxValue = null; // tear down range
	}
	
	
	
	
	
	/**
	 * Test 33
	 * Lowerbound is above max double allowed
	 * checks boundary case in an illegal argument range 
	 * to the right of the max argument line
	 * @throws Exception
	 */
	@Before
	public void setUp33() throws Exception {	
		double lowerValue = (Double.MAX_VALUE * 1.01); // number greater than the largest do9uble value
		lowerBoundAboveMaxValue = new Range(lowerValue, Double.POSITIVE_INFINITY); // lower bound above limit and so is upper //upper bound is at infinity
	}
	@Test(timeout = 1000) // a timeout of 1000
	public void testGetLowerBoundAboveMaxValue33(){ 
		double actualLowerBound = lowerBoundAboveMaxValue.getLowerBound(); // return the lower bound value which should be above max value overfow 
		double expectedlowerBound = Double.POSITIVE_INFINITY; // indicates overflow past maximum double value
		assertEquals("Checking that invalid lower limit causes overflow ", expectedlowerBound, actualLowerBound, .000000001d); // assert equals
	}
	@After
	public void tearDown33(){
		lowerBoundAboveMaxValue = null; // tear down range
	}


	
	
	/**
	 * Test 34
	 * lowerbound is larger than upper bound expect a exception thrown
	 * testing an illegal and special case for an argument 
	 */
	@Test(expected = IllegalArgumentException.class)  // expecting an exception to be thrown, fails if ot exception is thrown
	public void testGetLowerBoundWhenBiggerThanUpper34(){
		
		double lowerValue = 10; // below minimum double value for a primitive double
		lowerBoundAboveUpper = new Range( lowerValue , 0); // throws illegal args exception here since 
		lowerBoundAboveUpper.getLowerBound(); // calls getLowerBound(), test is s bit redundant sicne it tests ctor 
		//test can be seen as redundant but still tests the class fucntionality so doens't cause problems 
	}
	@After
	public void tearDown34()
	{
		lowerBoundAboveUpper = null; // tear down range
	}


}//end test class
