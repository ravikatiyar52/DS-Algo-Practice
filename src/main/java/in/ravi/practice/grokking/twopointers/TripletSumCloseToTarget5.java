/**
 * @author Ravi.Katiyar
 *
 *Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 *
 *Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

 * 
 */
package in.ravi.practice.grokking.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget5 {

	public static void main(String args[]) {
		int arr[] = { -3, -1, 1, 2 };
		System.out.println(searchTriplet(arr, 1));
	}

	/**
	 * This problem follows the Two Pointers pattern and is quite similar to Triplet
	 * Sum to Zero.
	 * 
	 * We can follow a similar approach to iterate through the array, taking one
	 * number at a time. At every step, we will save the difference between the
	 * triplet and the target number, so that in the end, we can return the triplet
	 * with the closest sum
	 * 
	 * @param arr
	 * @param targetSum
	 * @return
	 */
	public static int searchTriplet(int[] arr, int targetSum) {

		Arrays.sort(arr);
		int minimumDeviation = Integer.MAX_VALUE;
		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length - 2; i++) {

			int left = i + 1;
			int right = arr.length - 1;

			while (left < right) {
				int currentSum = arr[i] + arr[left] + arr[right];
				int deviation = targetSum - currentSum;

				// we found an exact match
				if (deviation == 0) {
					return currentSum;
				}

				if (Math.abs(deviation) < Math.abs(minimumDeviation)
						|| (Math.abs(deviation) == Math.abs(minimumDeviation) && deviation > minimumDeviation)) {
					minimumDeviation = deviation;
					minDiff = currentSum;
				}
				if (currentSum < targetSum) {
					left++;
				} else {
					right--;
				}

			}

		}
		return minDiff;
	}

}
