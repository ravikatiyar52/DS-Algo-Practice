/**
 * @author Ravi.Katiyar
 *
Given an array of n elements which contains elements from 0 to n-1, 
with any of these numbers appearing any number of times. 
Find these repeating numbers in O(n) and using only constant memory space.
For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 */
package in.ravi.practice.coding_practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 1, 3 };

		FindDuplicatesInArray findDuplicatesInArray = new FindDuplicatesInArray();
		List<Integer> duplicates = findDuplicatesInArray.getDuplicates(arr);

		for (int duplicate : duplicates) {
			System.out.print(duplicate + " ");
		}
	}

	/**
	 * We scan array from 0 to length -1. And at every index we check
	 * arr[abs(arr[i])] >0 then we make it negative. if it is already negative then
	 * abs(arr[[i]]) is duplicate
	 * 
	 * @param arr
	 * @return
	 */
	public List<Integer> getDuplicates(int arr[]) {
		List<Integer> duplicates = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int element = arr[Math.abs(arr[i])];

			if (element > 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];

			} else {
				duplicates.add(Math.abs(arr[i]));
			}
		}

		return duplicates;

	}

}
