/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 18-Dec-2019
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *  https://www.geeksforgeeks.org/trapping-rain-water/
 * 
 */
package in.ravi.practice.coding_practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWater {

	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_cases = Integer.parseInt(br.readLine());
		int[] outputs = new int[test_cases];
		int count = 0;

		while (count < test_cases) {
			
			int array_size = Integer.parseInt(br.readLine());
			int input[] = new int[array_size];

			String arrString = br.readLine();
			int i = 0;
			for (String token : arrString.split(" ")) {
				input[i++] = Integer.parseInt(token);
			}
			
			int waterTrapped = 0;

			for (int j = 0; j < input.length; j++) {

				int minOfMaxHeights = getMinOfMaxHeights(input, j);

				if (minOfMaxHeights - input[j] > 0) {
					waterTrapped += minOfMaxHeights - input[j];
				}
			}


			outputs[count] = waterTrapped;
			count++;
		}

		for (int output : outputs) {
			System.out.println(output);
		}
		br.close();

		
	}

	// This function returns the minimum of the max of the left and right heights
	public static int getMinOfMaxHeights(int arr[], int index) {

		int leftMax = 0;
		int rightMax = 0;

		for (int i = 0; i < index ; i++) {
			if (arr[i] > leftMax) {
				leftMax = arr[i];
			}
		}
		for (int i = index + 1; i < arr.length; i++) {
			if (arr[i] > rightMax) {
				rightMax = arr[i];
			}

		}

		return Math.min(leftMax, rightMax);

	}
}
