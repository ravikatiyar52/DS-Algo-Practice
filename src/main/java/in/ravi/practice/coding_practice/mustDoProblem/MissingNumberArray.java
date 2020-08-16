/**
 * @author Ravi.Katiyar
 *https://practice.geeksforgeeks.org/problems/missing-number-in-array/
 *
 *Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.

Input:
The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.

Output:
Print the missing number in array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ C[i] ≤ 107

Example:
Input:
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output:
4
9

Explanation:
Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 * 
 */
package in.ravi.practice.coding_practice.mustDoProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MissingNumberArray {
	
	public static void main(String args[]) {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String testCasesStr = bufferedReader.readLine();
			int testCases = Integer.parseInt(testCasesStr);
			int testCasesRead = 0;
			List<Integer> outputs = new ArrayList<Integer>();

			while (testCasesRead < testCases) {
				String inputSizeStr = bufferedReader.readLine();
				int inputSize = Integer.parseInt(inputSizeStr) -1;
				int[] inputArray = new int[inputSize];
				String inputArrayAsString = bufferedReader.readLine();
				int index = 0;
				for (String key : inputArrayAsString.split(" ")) {
					inputArray[index++] = Integer.parseInt(key);
				}
				int output = getMissingNumber(inputArray);
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
	
	
	private static int getMissingNumber(int[] input) {
		int missingNumber = Integer.MIN_VALUE;
		
		for(int indexIterator = 0; indexIterator < input.length;indexIterator ++) {
			int pickedElement = input[indexIterator];
			int indexToBeChanged = Math.abs(pickedElement) - 1;
			if(indexToBeChanged >= 0 && indexToBeChanged < input.length) {
				int valueToBeChanged = - input[indexToBeChanged];
				input[indexToBeChanged] = valueToBeChanged;
			}
		}

		for(int indexIterator = 0; indexIterator < input.length;indexIterator ++) {
			if(input[indexIterator] > 0) {
				missingNumber = indexIterator + 1;
				break;
			}
		}
		if(missingNumber == Integer.MIN_VALUE) {
			missingNumber = input.length + 1;
		}
		
		return missingNumber;
		
	}
}


