/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 02-Jan-2019
 * 
 */
package in.ravi.practice.coding_practice.arrays;

/**
 * 
 * @author Ravi.Katiyar
 *
 * Given an array arr[] of integers, 
 * find out the maximum difference between any two elements such that larger element appears after the smaller number.
Examples :

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7. 
 *
 */
public class MaxDiffArray {

	public static void main(String args[]) {
	int a[] = {72, 9, 5, 6, 3, 2};
	
	int smallest = a[0];
	int max_diff = a[1] - a[0];
	
	for (int i=1;i<a.length ;i++) {
		
		if(a[i] <smallest) {
			smallest = a[i];
		}
		
		if(a[i] - smallest > max_diff) {
			max_diff = a[i] - smallest;
		}
	}
	
	System.out.println(max_diff);
			
	}
}


