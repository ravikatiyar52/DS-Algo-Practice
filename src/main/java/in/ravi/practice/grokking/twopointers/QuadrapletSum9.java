/**
 * @author Ravi.Katiyar
 * 
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
 * 
 * Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.

Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
 * 
 */
package in.ravi.practice.grokking.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrapletSum9 {

	public static void main(String args[]) {
		int arr[] = {2,0,-1,1,-2,2};
		int target = 2;
		List<ArrayList<Integer>> quadraplets = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length-3;i++) {
			
			if(i >0 && arr[i] ==arr[i-1]) {
				i++;
				continue;
			}
			
			for(int j=i+1;j<arr.length -2;j++) {
				int newTarget = target - (arr[i] + arr[j]) ;
				findQuadraplet(arr, i, j, newTarget, quadraplets);
			}
		}
		
		System.out.println(quadraplets);
	}
	
	
	
	public static void findQuadraplet(int arr[],int first,int second,int target,List<ArrayList<Integer>> quadraplets){
		
		int third = second +1;
		int fourth = arr.length -1;
		
		while(third < fourth) {
			if(third > second +1 && arr[third] == arr[third -1]) {
				third ++;
				continue;
			}
			int currentSum = arr[third]+arr[fourth];
			if(currentSum == target) {
				ArrayList<Integer> quadraplet = new ArrayList<Integer>();
				quadraplet.add(arr[first]);
				quadraplet.add(arr[second]);
				quadraplet.add(arr[third]);
				quadraplet.add(arr[fourth]);
				quadraplets.add(quadraplet);
				third++;
				fourth --;
			}else if(currentSum < target) {
				third++;
			}else {
				fourth --;
			}
		}
		
	}
}


