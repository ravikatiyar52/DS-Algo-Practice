/**
 * @author Ravi.Katiyar
 *
 *Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
 *
 *Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
Output: 4
Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 *
 * 
 * Input: [2, 11, 2, 2, 1], Key=2
Output: 2
Explanation: The first two elements after removing every 'Key' will be [11, 1].
 * 
 */
package in.ravi.practice.grokking.twopointers;

public class RemoveGivenKey {

	public static void main(String args[]) {
		
		int arr[]= {2, 11, 2, 2, 1};
		int key =2;
		System.out.println(remove(arr,key));
	}
	
	public static int remove(int arr[],int key) {
		
		int nextValidIndex = 0;
		int iterator = 0;
		
		while(iterator < arr.length) {
			
			if(arr[iterator] != key) {
				arr[nextValidIndex] = arr[iterator];
				nextValidIndex ++;
			}
			iterator ++;
		}
		return nextValidIndex;
	}
}


