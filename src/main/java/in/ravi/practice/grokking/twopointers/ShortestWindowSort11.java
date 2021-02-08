/**
 * @author Ravi.Katiyar
 * 
 * 
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 * 
 * 
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

 * 
 * Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * 
 * 
 * 
 * Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted
**
*Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted.

 */
package in.ravi.practice.grokking.twopointers;

public class ShortestWindowSort11 {

	
	public static void main(String args[]) {
		int input1 [] = {1, 2, 5, 3, 7, 10, 9, 12};
		int input2 [] = {1, 3, 2, 0, -1, 7, 10};
		int input3 [] = {1, 2, 3};
		int input4 [] = {3, 2, 1};
		
		System.out.println(sort(input1));
		System.out.println(sort(input2));
		System.out.println(sort(input3));
		System.out.println(sort(input4));
	}
	
	public static int sort(int[] arr) {

		int shortestLenght = Integer.MAX_VALUE;
		
		int left = 0;
		int right = arr.length -1;
		
		while(left < arr.length -2 && arr[left+1] > arr[left] ) {
			left ++;
		}
		
		while(right >0 && arr[right-1] < arr[right]) {
			right --;
		}
		
		if(left >= right) {
			//this means array is already sorted
			shortestLenght = 0;
		}else {
			//now the array between left and right may be the array that we need to sort to make the whole array sorted.
			//I am saying may be because we might have to stretch the boundaries if the min element in this sub array is not greater than the first of element of this subarray
			// OR if the maximum element of this sub array is not smaller than the last element of this subarray. 
			//so next we find the min and max in this sub array and check if we need to extend the boundaries.
			int minInCandidateSubArray = Integer.MAX_VALUE;
			int maxInCandidateSubArray = Integer.MIN_VALUE;
			for(int i = left ; i<=right;i++) {
				if(arr[i] < minInCandidateSubArray) {
					minInCandidateSubArray = arr[i];
				}
				if(arr[i] > maxInCandidateSubArray) {
					maxInCandidateSubArray = arr[i];
				}
				
				//check if we need to extend the boundaries
				while( left >= 1 && arr[left -1] > minInCandidateSubArray ) {
					left --;
				}
				
				while(right <= arr.length -2 && arr[right + 1] < maxInCandidateSubArray ) {
					right ++;
				}
				
				shortestLenght = (right - left) + 1;
			}
		}
		
	    return shortestLenght;
	  }
}
