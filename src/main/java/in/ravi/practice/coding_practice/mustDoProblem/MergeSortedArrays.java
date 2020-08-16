/**
 * @author Ravi.Katiyar
 * 
 * Merge Without Extra Space
 * 
 * Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
 *
 * 
 */
package in.ravi.practice.coding_practice.mustDoProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {

	public static void main(String args[]) {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String testCasesStr = bufferedReader.readLine();
			int testCases = Integer.parseInt(testCasesStr);
			int testCasesRead = 0;
			List<String> outputs = new ArrayList<String>();

			while (testCasesRead < testCases) {
				String inputSizeStr = bufferedReader.readLine();
				String[] arraySizes = inputSizeStr.split(" ");
				int inputSize1 = Integer.parseInt(arraySizes[0]);
				int inputSize2 = Integer.parseInt(arraySizes[1]);
				int[] inputArray1 = new int[inputSize1];
				int[] inputArray2 = new int[inputSize2];
				String inputArrayAsString = bufferedReader.readLine();
				int index = 0;
				for (String key : inputArrayAsString.split(" ")) {
					inputArray1[index++] = Integer.parseInt(key);
				}
				inputArrayAsString = bufferedReader.readLine();
				 index = 0;
				for (String key : inputArrayAsString.split(" ")) {
					inputArray2[index++] = Integer.parseInt(key);
				}
				mergeArrays(inputArray1,inputArray2);
				StringBuffer sb = new StringBuffer();
				for(int num : inputArray1) {
					sb.append(num + " ");
				}
				for(int num : inputArray2) {
					sb.append(num + " ");
				}
				outputs.add(sb.toString());
				testCasesRead++;
			}

			for (String output : outputs) {
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
	
	
	
	private static void mergeArrays (int[] arr1,int[] arr2) {
		/**
		 * 1. iterate the first array
		 * 2. for every element if the element is greater than the first element of second array swap that element with first element of second array.
		 * 3. Now check if the second array is still sorted
		 * 4. To sort the second array just find the correct position of the swapped element
		 */
		
		for(int arr2Iterator = arr2.length-1; arr2Iterator >= 0;arr2Iterator --) {
			
			if(arr2[arr2Iterator] < arr1[arr1.length - 1]) {
				int temp = arr2[arr2Iterator];
				arr2[arr2Iterator] = arr1[arr1.length - 1];
				arr1[arr1.length - 1] = temp;
				checkIFStillSorted(arr1);
			}
		}
		
	}

	private static void checkIFStillSorted(int[] arr2) {
		int index = arr2.length - 1;
		while( index -1 >= 0 && arr2[index] < arr2[index-1]) {
			int temp = arr2[index];
			arr2[index] = arr2[index-1];
			arr2[index-1] = temp;
			index --;
		}
		
		
	}
}


