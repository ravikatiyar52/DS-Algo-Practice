/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 19-Jun-2019
 
 */
package in.ravi.practice.coding_practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MaxSumNonAdjacent {

	private static int maxSumNonAdjacent(int[] input) {

		int including = input[0];
		int excluding = 0;

		for (int i = 1; i < input.length; i++) {
			int temp = including;
			if (Math.max(excluding + input[i], including) > including) {
				including = excluding + input[i];
			}
			excluding = temp;
		}

		return Math.max(including, excluding);
	}

	public static void main(String args[]) throws IOException {

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

			outputs[count] = maxSumNonAdjacent(input);
			count++;
		}

		for (int output : outputs) {
			System.out.println(output);
		}
		br.close();
	}

	/*
	 * public static void main(String args[]) {
	 * 
	 * int[] input = { 10 }; System.out.println(maxSumNonAdjacent(input));
	 * 
	 * }
	 */}