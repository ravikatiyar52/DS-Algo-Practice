/**
 * @author Ravi.Katiyar
 *Given an array of positive numbers and a positive number ‘S’, 
 *find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 *
 *Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 *
 *Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * 
 */
package in.ravi.practice.grokking.slidingWindow;

public class SmallestSubArraySum1 {
	
	public static void main(String args[]) {
		int [] arr= {2,1,5,2,3,2};
		int sum = 7;
		int smallestLength = getSmallestLengthSubArraySum(sum,arr);
		System.out.println(smallestLength);
	}
	
	
	public static int getSmallestLengthSubArraySum( int S,int arr[]) {
		int smallestLength = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int currentSum = arr[start];
		while (end < arr.length && start < arr.length) {
			while (currentSum < S ) {
				// slide the window
				end++;
				if(end <arr.length ) {
					currentSum += arr[end];	
				}
			}
			if (end - start < smallestLength && currentSum >= S) {
				smallestLength = end - start;
			}
			// lets try to shrink the window
			currentSum = currentSum - arr[start];
			start ++;
			while (currentSum >= S && start <= end) {
				if (end - start < smallestLength) {
					smallestLength = end - start;
				}
				currentSum = currentSum - arr[start];
				start++;
			}
			end++;
			if(end <arr.length ) {
				currentSum += arr[end];	
			}
		}
		if (smallestLength == Integer.MAX_VALUE) {
			smallestLength = -1;
		}
		return smallestLength + 1;
	}
}


