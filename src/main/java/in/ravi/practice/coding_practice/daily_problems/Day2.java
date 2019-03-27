/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 24-Feb-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             24-Feb-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.daily_problems;

/**
 * 
 * This problem was asked by Uber.
 * 
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 * 
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would
 * be [2, 3, 6].
 * 
 * Follow-up: what if you can't use division?
 *
 */
public class Day2 {

	public static void main(String args[]) {

		int arr[] = { 2, 3, 4, 5, 6 };

		int[] productArray = getProductArrayDivisionNotAllowed(arr);
		int[] productArray2 = getProductArrayDivisionAllowed(arr);

		for (int ele : productArray) {
			System.out.print(ele + "  ");
		}
		System.out.println();
		for (int ele : productArray2) {
			System.out.print(ele + "  ");
		}
	}

	public static int[] getProductArrayDivisionAllowed(int input[]) {

		int[] productArray = new int[input.length];
		int allElementsProduct = 1;

		for (int element : input) {
			allElementsProduct = allElementsProduct * element;
		}

		for (int i = 0; i < productArray.length; i++) {
			productArray[i] = allElementsProduct / (input[i]);
		}

		return productArray;
	}

	/**
	 * We create two temp arrays left and right the left[i] = product of all the
	 * elements towards the left of input[i] except input[i] right[i] = product of
	 * all the elements towards the right of input[i] except input[i]
	 * 
	 * now productArray[i] = left[i] * right[i]
	 * 
	 * @param input
	 * @return
	 */

	public static int[] getProductArrayDivisionNotAllowed(int input[]) {

		int[] productArray = new int[input.length];
		int[] left = new int[input.length];
		int[] right = new int[input.length];

		// nothing to the left of first element
		left[0] = 1;
		for (int i = 1; i < input.length; i++) {
			left[i] = left[i - 1] * input[i - 1];
		}

		// nothing to the right of last element
		right[input.length - 1] = 1;
		for (int i = input.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * input[i + 1];
		}

		for (int i = 0; i < input.length; i++) {
			productArray[i] = left[i] * right[i];
		}

		return productArray;
	}

}
