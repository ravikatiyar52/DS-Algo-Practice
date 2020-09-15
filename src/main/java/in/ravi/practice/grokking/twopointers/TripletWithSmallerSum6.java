/**
 * @author Ravi.Katiyar
 *
 *
 *Input: [-1, 0, 2, 3], target=3 
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

 *
 *Input: [-1, 4, 2, 1, 3], target=5 
Output: 4
Explanation: There are four triplets whose sum is less than the target: 
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
  * 
 */
package in.ravi.practice.grokking.twopointers;

import java.util.Arrays;

public class TripletWithSmallerSum6 {

	public static void main(String args[]) {

		int arr[] = { -1, 0, 2, 3 };
		int target = 3;
		System.out.println(searchTriplets(arr, target));
	}

	/**
	 * This problem follows the Two Pointers pattern and shares similarities with
	 * Triplet Sum to Zero. The only difference is that, in this problem, we need to
	 * find the triplets whose sum is less than the given target. To meet the
	 * condition i != j != k we need to make sure that each number is not used more
	 * than once.
	 * 
	 * Following a similar approach, first, we can sort the array and then iterate
	 * through it, taking one number at a time. Let’s say during our iteration we
	 * are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X + Y + Z <
	 * targetX+Y+Z<target. At this stage, our problem translates into finding a pair
	 * whose sum is less than “target - Xtarget−X” (as from the above equation Y + Z
	 * == target - XY+Z==target−X). We can use a similar approach as discussed in
	 * Triplet Sum to Zero
	 * 
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int searchTriplets(int[] arr, int target) {
		int count = 0;

		if (null == arr || arr.length < 3) {
			throw new IllegalArgumentException("Input array should contain at least 3 elements");
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1;
			count += findPair(arr, left, target - arr[i]);
		}
		return count;
	}

	private static int findPair(int arr[], int left, int targetSum) {

		int count = 0;
		int right = arr.length - 1;

		while (left < right) {
			// found the triplet
			// since arr[right] >= arr[left], therefore, we can replace arr[right] by any
			// number between
			// left and right to get a sum less than the target sum
			if (arr[left] + arr[right] < targetSum) {
				count += right - left;
				left++;
			} else {
				// need a pair with smaller sum
				right--;
			}
		}
		return count;
	}
}
