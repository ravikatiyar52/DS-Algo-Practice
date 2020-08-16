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
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Ravi.Katiyar
 * 1. Prefix sum is the sum of all elements upto that index
 * 2. 
 * 
 *
 */
public class SubArrayWithGivenSumAlsoOutputIndexFound {

	public static String subArrayFound(int[] array, int sumToCheck) {

		String outputString = "-1";
		Map<Integer, Integer> prefixSumIndexMap = new HashMap<Integer, Integer>();
		int preFixSum = 0;
		for (int i = 0; i < array.length; i++) {
			preFixSum += array[i];
			if (array[i] == sumToCheck) {
				outputString = Integer.toString(i + 1) + " " + Integer.toString(i + 1);
				break;
			} else if (preFixSum == sumToCheck) {
				outputString = "1" + " " + Integer.toString(i+1);
				break;
			} else if (null != prefixSumIndexMap.get(preFixSum - sumToCheck)) {
				int startIndex = prefixSumIndexMap.get(preFixSum - sumToCheck) + 1;
				outputString = Integer.toString(startIndex) + " " + Integer.toString(i + 1);
				break;
			}
			prefixSumIndexMap.put(preFixSum, i+1);
		}
		return outputString;
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_cases = Integer.parseInt(br.readLine());
		String[] outputs = new String[test_cases];
		int count = 0;

		while (count < test_cases) {
			String sizeAndSumStr[] = br.readLine().split(" ");
			int array_size = Integer.parseInt(sizeAndSumStr[0]);
			int sumToFind = Integer.parseInt(sizeAndSumStr[1]);
			int input[] = new int[array_size];

			String arrString = br.readLine();
			int i = 0;
			for (String token : arrString.split(" ")) {
				input[i++] = Integer.parseInt(token);
			}

			outputs[count] = subArrayFound(input, sumToFind);
			count++;
		}

		for (String output : outputs) {
			System.out.println(output);
		}
		br.close();

	}
}
