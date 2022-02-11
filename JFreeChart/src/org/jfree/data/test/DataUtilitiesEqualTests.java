package org.jfree.data.test;

import static org.junit.Assert.*;							
import org.jfree.data.DataUtilities;
import org.junit.*;

/**
 * 
 * @author chace
 * Class to test method DataUtilities.equal(double [][] a, double [][] b) in the DataUtilities class
 */
public class DataUtilitiesEqualTests {

	
	double[][]a1,b1; // two 2d arrays for each of teh 5 tests
	double[][]a2,b2;
	double[][]a3,b3;
	double[][]a4,b4;
	double[][]a5,b5;
	
	

	/**
	 * Test 35
	 * This tests has inputs of two null arrays 
	 * focused on boundry case with specific checked input
	 * @throws Exception
	 */
	@Before
	public void setUp35() throws Exception {	
		a1= null; // make sure arrays are null
		b1= null;
	}
	@Test(timeout = 1000) //timer set
	public void testCompareNullToNullArrays35(){ 
		boolean actual = DataUtilities.equal(a1,b1); // call function and save boolean return value
		assertTrue("checking both null arrays should be equal", actual); //asserttrue call to check return value
	}
	@After
	public void tearDown35(){
		a1= null;  // set arrays to null for teardown
		b1= null;
	}
	
	
	
	
	
	
	/**
	 * Test 36
	 * Test inputs are filled array and null array
	 * boundary case with one null array
	 * @throws Exception
	 */
	@Before
	public void setUp36() throws Exception {	
		a2= null; // make sure array is null
		b2= new double[][]{{1,2,3},{1,2,4}}; // one array with values 
	}
	@Test(timeout = 1000) //timer set
	public void testCompareNonNullToNullArrays36(){ 
		boolean actual = DataUtilities.equal(a2,b2); // call function and save boolean return value
		assertFalse("checking thats null array isn't equal to non null array", actual);  //assertfalse call to check return value
	}
	@After
	public void tearDown36(){
		a2= null;// set arrays to null for teardown
		b2= null;
	}
	
	
	
	
	/**
	 * Test 37
	 * inputs are two identical arrays
	 * boundary case with basic input
	 * @throws Exception
	 */
	@Before
	public void setUp37() throws Exception {	
		a3= new double[][]{{1,2,3},{1,2,4},{4,5,6,8,9}};  // set arrays that are identical
		b3= new double[][]{{1,2,3},{1,2,4},{4,5,6,8,9}};
	}
	@Test(timeout = 1000) //timer set
	public void testCompareNonNullToNonNullArrays37(){ 
		boolean actual = DataUtilities.equal(a3,b3); // call function and save boolean return value
		assertTrue("checking thats arrays are equal", actual); //asserttue call to check return value
	}
	@After
	public void tearDown37(){
		a3= null;// set arrays to null for teardown
		b3= null;
	}
	
	

	/**
	 * Test 38
	 * inputs two differnt arrays that are non null
	 * boundry case to check for a false return
	 * @throws Exception
	 */
	@Before
	public void setUp38() throws Exception {	
		a4= new double[][]{{1,2,3},{1,2,4},{4,5,6,8,9}};  // set arrays that have differnt values
		b4= new double[][]{{1,2,3},{1,2,40},{4,5,6,8,9}};
	}
	@Test(timeout = 1000) //timer set
	public void testCompareNonNullToNonNullArrays38(){ 
		boolean actual = DataUtilities.equal(a4,b4); // call function and save boolean return value
		assertFalse("checking thats arrays are not equal", actual); //assertfalse call to check return value
	}
	@After
	public void tearDown38(){
		a4= null;// set arrays to null for teardown
		b4= null;
	}
	
	
	
	
	/**
	 * Test 39
	 * inputs two non null arrays with different dimensions
	 * boundary case similar to test 38 but checking another possibility
	 * to have redundancy
	 * @throws Exception
	 */
	@Before
	public void setUp39() throws Exception {	
		a5= new double[][]{{1,2,3},{1,2,4},{4,5,6,8,9}}; // set arrays that have differnt dimension
		b5= new double[][]{{1,2,3},{1,2,4},{4,5,6,8,9},{10}};
	}
	@Test(timeout = 1000) //timer set
	public void testCompareNonNullToNonNullArrays39(){ 
		boolean actual = DataUtilities.equal(a5,b5); // call function and save boolean return value
		assertFalse("checking thats arrays are not equal", actual); //assertfalse call to check return value
	}
	@After
	public void tearDown39(){
		a5= null;// set arrays to null for teardown
		b5= null;
	}

}//end test class
