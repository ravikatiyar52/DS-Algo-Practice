
package in.ravi.practice.grokking.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ravi.Katiyar
 *
 *Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, 
 *find the length of the longest contiguous subarray having all 1s.
 *
 *Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6
*
*
*Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9
 *
 */
public class ReplacingOnes5 {
	
	public static void main(String args[]) {
		
		int input[] = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
		int k =3;
		
		System.out.println(findLength(input, k));
		
	}
	
	
	public static int findLength(int[] arr, int k) {
		int start = 0;
		int end = -1;
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		int max1Count = 0;
		int maxLength = 0;

		while (end < arr.length - 1) {
			end++;
			freqMap.put(arr[end], freqMap.getOrDefault(arr[end], 0) + 1);
			
			if(freqMap.getOrDefault(1,0) > max1Count) {
				max1Count = freqMap.get(1);
			}
			if (((end-start) +1) - max1Count > k) {
				freqMap.put(arr[start], freqMap.get(arr[start]) - 1);
				start ++;
			}
			if(freqMap.getOrDefault(1,0) > 0) {
				maxLength = Math.max(maxLength, (end - start) + 1);
			}
			
		}
		return maxLength;
	}

}


