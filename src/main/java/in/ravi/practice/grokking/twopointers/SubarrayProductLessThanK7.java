/**
 * @author Ravi.Katiyar
 *
 *Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
 *
 *Input: [2, 5, 3, 10], target=30 
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.
 *
 * 
 * Input: [8, 2, 6, 5], target=50 
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5] 
Explanation: There are seven contiguous subarrays whose product is less than the target.
 * 
 */
package in.ravi.practice.grokking.twopointers;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK7 {
	
	public static void main(String args[]) {
		
		int [] input = {10,5,2,6};
		int target = 100;
		List<List<Integer>> result = findSubarrays(input, target);
		System.out.println(result);
	}

	public static List<List<Integer>> findSubarrays(int[] nums, int k) {
		List<List<Integer>> subarrays = new ArrayList<>();

		int left = 0;
		int right = 0;
		int currentWindowProduct = 1;

		while (right < nums.length) {

			if (nums[right] < k) {
				List<Integer> subArray = new ArrayList<>(4);
				subArray.add(nums[right]);
				subarrays.add(subArray);
			}
			currentWindowProduct *= nums[right];

			if (right - left > 0) {
				if (currentWindowProduct < k) {
					List<Integer> subArray = new ArrayList<>(4);
					for (int i = left; i <= right; i++) {
						subArray.add(nums[i]);
					}
					subarrays.add(subArray);
				} else {
					while (left < right-1) {
						currentWindowProduct /= nums[left];
						left++;
						if (currentWindowProduct < k) {
							List<Integer> subArray = new ArrayList<>(4);
							for (int i = left; i <= right; i++) {
								subArray.add(nums[i]);
							}
							subarrays.add(subArray);
						}
					}
				}
			}
			right++;
		}

		while (left < nums.length - 2 && currentWindowProduct < k) {
			currentWindowProduct /= nums[left];
			left++;

			List<Integer> subArray = new ArrayList<>(4);
			for (int i = left; i < nums.length ; i++) {
				subArray.add(nums[i]);
			}
			subarrays.add(subArray);

		}
		
		return subarrays;
	}
}
