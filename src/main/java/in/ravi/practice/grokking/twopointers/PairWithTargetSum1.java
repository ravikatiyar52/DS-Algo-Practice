/**
 * @author Ravi.Katiyar
 * 
 */
package in.ravi.practice.grokking.twopointers;

/**
 * 
 * @author Ravi.Katiyar
 * 
 *         Given an array of sorted numbers and a target sum, find a pair in the
 *         array whose sum is equal to the given target.
 * 
 *         Write a function to return the indices of the two numbers (i.e. the
 *         pair) such that they add up to the given target.
 * 
 *         Input: [1, 2, 3, 4, 6], target=6 Output: [1, 3] Explanation: The
 *         numbers at index 1 and 3 add up to 6: 2+4=6
 *
 */
public class PairWithTargetSum1 {
	
	public static void main(String args[]) {

		int input[] = { 1, 2, 3, 4, 6 };
		int target = 6;

		int output[] = search(input, target);
		System.out.println(output[0] + " " + output[1]);
	}
	
	public static int[] search(int[] arr, int targetSum) {

		int left = 0;
		int right = arr.length - 1;
		int result[] = new int[2];

		while (left < right) {

			int currentSum = arr[left] + arr[right];

			if (currentSum == targetSum) {
				result[0] = left;
				result[1] = right;
				return result;
			}

			if (currentSum > targetSum) {
				right--;
			} else {
				left++;
			}

		}

		return new int[] { -1, -1 };
	}
	

}
