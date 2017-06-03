package com.campaignmonitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.campaignmonitor.exceptions.InvalidTriangleException;

/**
 * This class will unit test the LanguageRequirements class functionalities
 * @author Sinto
 *
 */
public class LanguageRequirementTest {

	LanguageRequirements lr = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lr=new LanguageRequirements();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsNullOrEmptyWithNull() {
		assertTrue("This should return true because the input is null", lr.isNullOrEmpty(null)); 
	}
	@Test
	public void testIsNullOrEmptyWithProperString() {
		assertFalse("This should return false because the input is a real string", lr.isNullOrEmpty("a")); 
	}
	@Test
	public void testIsNullOrEmptyWithEmptyString() {
		assertTrue("This should return true because the input is Empty String", lr.isNullOrEmpty("")); 
	}
	@Test
	public void testIsNullOrEmptyWithNullString() {
		assertFalse("This should return false because the input is a null string", lr.isNullOrEmpty("null")); 
	}
	@Test
	public void testGetPositiveDivisorsMethodWithValidPositiveInteger1() {
		List<Integer> resultList =Arrays.asList(1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60); 
		assertEquals(resultList,lr.getPositiveDivisors(60)) ;
	}
	@Test
	public void testGetPositiveDivisorsMethodWithValidPositiveInteger2() {
		List<Integer> resultList =Arrays.asList(1, 2, 3, 6, 7, 14, 21, 42); 
		assertEquals(resultList,lr.getPositiveDivisors(42)) ;
	}
	@Test(expected=RuntimeException.class)
	public void testGetPositiveDivisorsMethodWithZero() {
		lr.getPositiveDivisors(0);
	}
	@Test(expected=RuntimeException.class)
	public void testGetPositiveDivisorsMethodWithNegative() {
		lr.getPositiveDivisors(-10);
	}
	@Test
	public void testGetTriangleAreaForValidInput1() {
		assertEquals(6,lr.getTriangleArea(3, 4, 5),0.0) ;
	}
	@Test(expected=InvalidTriangleException.class)
	public void testGetTriangleAreaForNegativeValue() {
		lr.getTriangleArea(-3, 4, 5);
	}
	@Test(expected=InvalidTriangleException.class)
	public void testGetTriangleAreaForInvalidValue() {
		lr.getTriangleArea(2, 8, 5);
	}
	@Test
	public void testGetCommonElementsWithValidArgument() {
		int inputArray[] = {5, 4, 3, 2, 4, 5, 1, 6, 1, 2, 5, 4};
		int a[] = lr.getCommonElements(inputArray);
		assertEquals(2, a.length);
	}
	@Test
	public void testGetCommonElementsWithValidArgument2() {
		int inputArray[] = {1, 2, 3, 4, 5, 1, 6, 7};
		int a[] = lr.getCommonElements(inputArray);
		assertEquals(1, a.length);
	}
	@Test(expected=RuntimeException.class)
	public void testGetCommonElementsWithInvalidArray() {
		int inputArray[] = {};
		lr.getCommonElements(inputArray);
	}
	@Test(expected=RuntimeException.class)
	public void testGetCommonElementsWithNullArray() {
		int inputArray[] = null;
		lr.getCommonElements(inputArray);
	}
}
