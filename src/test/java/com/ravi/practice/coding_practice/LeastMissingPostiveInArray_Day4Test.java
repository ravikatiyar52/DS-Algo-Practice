/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 26-Mar-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             26-Mar-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 26-Mar-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             26-Mar-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package com.ravi.practice.coding_practice;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import in.ravi.practice.coding_practice.daily_problems.LeastMissingPostiveInArray_Day4;

/**
 * @author Ravi.Katiyar
 *
 * 
 * 
 */
public class LeastMissingPostiveInArray_Day4Test {

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link in.ravi.practice.coding_practice.daily_problems.LeastMissingPostiveInArray_Day4#seperatePositiveInArray(int[])}.
	 */
	@Test
	public void testSeperatePositiveInArray() {
		LeastMissingPostiveInArray_Day4 leastMissingPostiveInArray_Day4 = new LeastMissingPostiveInArray_Day4();
		int input[] = { 2, 3, 7, 6, 8, 1, -10, 15 };
		// int expectedOutput[] = { -1, -10, 7, 6, 8, 2, 3, 15 };
		int expectedOutput = 1;
		int actualOutput = leastMissingPostiveInArray_Day4.seperatePositiveInArray(input);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void getLeastMissingPositive() {
		LeastMissingPostiveInArray_Day4 leastMissingPostiveInArray_Day4 = new LeastMissingPostiveInArray_Day4();
		int input1[] = { 1, 2, 3, 7, 9012, 4, -11, -5 };
		int expectedOutput1 = 5;
		int input2[] = { 2, 3, 7, 6, 8, -1, -10, 15 };
		int expectedOutput2 = 1;
		int input3[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
		int expectedOutput3 = 4;
		int input4[] = { 1, 1, 0, -1, -2 };
		int expectedOutput4 = 2;
		int input5[] = { 1, 2, 0 };
		int expectedOutput5 = 3;
		int input6[] = { 1, 2, 3, 7, -6, -4, -11, -5,9,7,8,6 };
		int expectedOutput6 = 4;

	/*	int actualOutput1 = leastMissingPostiveInArray_Day4.getLeastMissingPositive(input1);
		int actualOutput2 = leastMissingPostiveInArray_Day4.getLeastMissingPositive(input2);
		int actualOutput3 = leastMissingPostiveInArray_Day4.getLeastMissingPositive(input3);
		int actualOutput4 = leastMissingPostiveInArray_Day4.getLeastMissingPositive(input4);
		int actualOutput5 = leastMissingPostiveInArray_Day4.getLeastMissingPositive(input5);
		int actualOutput6 = leastMissingPostiveInArray_Day4.getLeastMissingPositive(input6);
*/
		/*assertEquals(expectedOutput1, actualOutput1);
		assertEquals(expectedOutput2, actualOutput2);
		assertEquals(expectedOutput3, actualOutput3);
		assertEquals(expectedOutput4, actualOutput4);
		assertEquals(expectedOutput5, actualOutput5);
		assertEquals(expectedOutput6, actualOutput6);
*/
	}

}
