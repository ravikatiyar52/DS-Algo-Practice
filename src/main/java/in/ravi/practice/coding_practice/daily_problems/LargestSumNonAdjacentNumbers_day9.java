/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 08-Apr-2019
 *
 *This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
 * 
 * 
 */
package in.ravi.practice.coding_practice.daily_problems;

/**
 * Let M(i) represent max sum of non adjacent indexes from 0 to i.
 * Base case M(0) = a[0] and M(-1) = 0.
 * public static void main(String... doYourBest) {
    	    Simpson simpson = new Simpson();
    	    transformIntoHomer(simpson);
    	    System.out.println(simpson.name);
	}

	static void transformIntoHomer(Simpson simpson) {
    	    simpson.name = "Homer";
	}Then M(i) = Max(a[i]+M(i-2),M(i-1))
 * M(n) is the solution we need (n is the last element in the array)
 */
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestSumNonAdjacentNumbers_day9 {

	public static int getLargestNonAdjacentSum(int a[], int i, int memoization[]) {

		/*
		 * if (i == -1) { return 0; }
		 * 
		 * if (i == 0) { return a[0]; }
		 * 
		 * if (i == 1) { return Math.max(a[0], a[1]); }
		 */

		return Math.max(a[i] + memoization[i - 2], memoization[i - 1]);

	}

	/*
	 * public static void main(String args[]) {
	 * 
	 * //int input[] = { 2, 4, 6, 2, 5 }; int input[] = { 5, 1, 1, 5,5 };
	 * 
	 * int memoization[] = new int[input.length];
	 * 
	 * for (int i = 0; i < input.length; i++) { memoization[i] =
	 * getLargestNonAdjacentSum(input, i, memoization); }
	 * 
	 * System.out.println(memoization[memoization.length - 1]);
	 * 
	 * }
	 */

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		List<Integer> outputs = new ArrayList<Integer>();

		int testCase = 1;
		while (testCase <= numberOfTestCases) {

			int arrayLength = scanner.nextInt();
			int inputArray[] = new int[arrayLength];
			// int messageInt = scanner.nextInt();

			for (int i = 0; i < arrayLength; i++) {
				inputArray[i] = scanner.nextInt();
			}

			int[] memoization = new int[arrayLength];
			memoization[0] = inputArray[0];
			memoization[1] = Math.max(inputArray[0], inputArray[1]);
			for (int i = 2; i < arrayLength; i++) {
				memoization[i] = getLargestNonAdjacentSum(inputArray, i, memoization);
			}

			int output = memoization[arrayLength - 1];
			outputs.add(output);
			testCase++;
		}
		for (int output : outputs) {
			System.out.println(output);
		}
		scanner.close();

	}

}
