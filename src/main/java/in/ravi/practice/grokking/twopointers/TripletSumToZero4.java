/**
 * @author Ravi.Katiyar
 *
 *Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 *Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
 *
 *
 *Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
 *
 */
package in.ravi.practice.grokking.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero4 {

	public static void main(String args[]) {
		int input[] = {-3, 0, 1, 2, -1, 1, -2};
		List<List<Integer>> triplets = searchTriplets(input);
		System.out.println(triplets);
	}
	
	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i - 1] == arr[i]) {
				continue;
			}
			List<Integer> output = new ArrayList<Integer>(8);
			output.add(arr[i]);
			findPair(arr, -arr[i], i + 1, triplets);

		}

		return triplets;
	}
	
	
	private static void findPair(int arr[], int target, int left, List<List<Integer>> triplets) {


		int right = arr.length - 1;

		while (left < right) {

			int currentSum = arr[left] + arr[right];

			if (currentSum == target) {
				triplets.add(Arrays.asList(-target, arr[left], arr[right]));
				left ++;
				right --;

				while (left < right && arr[left - 1] == arr[left]) {
					left++;
				}

				while (left < right && arr[right] == arr[right + 1]) {
					right--;
				}

			} else if (currentSum > target) {
				right--;
			} else {
				left++;
			}

		}

	}
	
}
