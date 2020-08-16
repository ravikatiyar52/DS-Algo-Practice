/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 21-Jun-2019
 
 * 
 */
package in.ravi.practice.coding_practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {

	public static String subArrayFound(int[] array, int sumToCheck) {

		String found = "No";
		Set<Integer> set = new HashSet<Integer>(array.length);
		int preFixSum = 0;

		for (int key : array) {
			preFixSum += key;
			if (key == sumToCheck || set.contains(preFixSum - sumToCheck) || preFixSum == sumToCheck) {
				found = "Yes";
				break;
			}
			set.add(preFixSum);
		}

		return found;

	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_cases = Integer.parseInt(br.readLine());
		String[] outputs = new String[test_cases];
		int count = 0;

		while (count < test_cases) {
			int array_size = Integer.parseInt(br.readLine());
			int input[] = new int[array_size];

			String arrString = br.readLine();
			int i = 0;
			for (String token : arrString.split(" ")) {
				input[i++] = Integer.parseInt(token);
			}

			outputs[count] = subArrayFound(input, 0);
			count++;
		}

		for (String output : outputs) {
			System.out.println(output);
		}
		br.close();

	}
}
