/**
 * @author Ravi.Katiyar
 *
 *https://practice.geeksforgeeks.org/problems/kadanes-algorithm/
 *
 *Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray
 * 
 */
package in.ravi.practice.coding_practice.mustDoProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KadanesAlgorithm {

	public static void main(String args[]) {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String testCasesStr = bufferedReader.readLine();
			int testCases = Integer.parseInt(testCasesStr);
			int testCasesRead = 0;
			List<Integer> outputs = new ArrayList<Integer>();

			while (testCasesRead < testCases) {
				String inputSizeStr = bufferedReader.readLine();
				int inputSize = Integer.parseInt(inputSizeStr);
				int[] inputArray = new int[inputSize];
				String inputArrayAsString = bufferedReader.readLine();
				int index = 0;
				for (String key : inputArrayAsString.split(" ")) {
					inputArray[index++] = Integer.parseInt(key);
				}
				int output = getMaxSumContiguous(inputArray);
				outputs.add(output);
				testCasesRead++;
			}

			for (int output : outputs) {
				System.out.println(output);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("something went wrong ");
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

	private static int getMaxSumContiguous(int[] inputArray) {

		int overallMax = Integer.MIN_VALUE;
		int max_so_far = 0;
		
		for(int index = 0 ; index <inputArray.length;index ++) {
			max_so_far += inputArray[index];
			
			if(inputArray[index] > max_so_far) {
				max_so_far = inputArray[index];
			}
			
			if(max_so_far > overallMax) {
				overallMax = max_so_far;
			}
		}
		
		return overallMax;
	}
	
	
}


