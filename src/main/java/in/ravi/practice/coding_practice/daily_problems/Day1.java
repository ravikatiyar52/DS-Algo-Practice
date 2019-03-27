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

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Ravi.Katiyar
 *
 *         Given a list of numbers and a number k, return whether any two
 *         numbers from the list add up to k.
 * 
 *         For example, given [10, 15, 3, 7] and k of 17, return true since 10 +
 *         7 is 17.
 * 
 *         Bonus: Can you do this in one pass?
 *
 */
public class Day1 {
	
	public static void main(String args[]) {
		int arr[] = { 10, 15, 3, 8 };
		int key = 11;

		//boolean result = checkNumberSum(arr, key);
		boolean result = checkNumberSumBruteForce(arr, key);
		
		System.out.println(result);
	}

	public static boolean checkNumberSumBruteForce(int arr[], int key) {

		boolean found = false;

		if (arr.length > 1) {

			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] + arr[j] == key) {
						found = true;
						break;
					}
				}
				if (found == true) {
					break;
				}
			}

		} else {
			System.out.println("array doesn't have two elements");
		}

		return found;
	}
	
	public static boolean checkNumberSum(int arr[] , int key) {
		
		boolean found = false;
		
		/**
		 * 1.We need to find if there exist two numbers(X and Y) in array whose addition = key. i.e X + Y = key.
		 * 2.Iterate through the input array:
		 * 		if number picked is X then Y has to be key - X, therefore if there exist a number = key - X in our set , we found the two numbers
		 *      else add this X to set . 
		 * 
		 */
		
		Set<Integer> inputArraySet = new HashSet<Integer>();
		
		for(int x : arr) {
			int y = key -x;
			
			if(inputArraySet.contains(y)) {
				found = true;
				break;
			}
			inputArraySet.add(x);
		}
		
		return found;
		
	}


}


