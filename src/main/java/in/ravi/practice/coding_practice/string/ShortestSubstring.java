/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 24-Jun-2019
 * 
 */
package in.ravi.practice.coding_practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ShortestSubstring {

	public static int getSubStringLength(String s) {
		int output = Integer.MAX_VALUE;
		Set<Character> charSet = new HashSet<Character>();
		char[] inputCharArr = s.toCharArray();
		for (char c : inputCharArr) {
			charSet.add(c);
		}

		Set<Character> charSetTemp = new HashSet<Character>(charSet);
		int prevIndex = 0;

		for (int currentIndex = 0; currentIndex < inputCharArr.length; currentIndex++) {

			charSetTemp.remove(inputCharArr[currentIndex]);

			if (charSetTemp.isEmpty()) {

				String candidateString = s.substring(prevIndex, currentIndex + 1);
				String actualString = removeStratingAndTrailingDuplicates(candidateString);

				if (actualString.length() < output) {
					output = actualString.length();
					prevIndex = currentIndex;
					charSetTemp = new HashSet<Character>(charSet);
					continue;
				}

			}

		}

		return output;
	}

	public static String getShortestSubString(String s) {

		Set<Character> charSet = new HashSet<Character>();
		char[] inputCharArr = s.toCharArray();
		for (char c : inputCharArr) {
			charSet.add(c);
		}

		Set<Character> charSetTemp = new HashSet<Character>(charSet);
		int prevIndex = 0;
		String outputString = s;

		for (int currentIndex = 0; currentIndex < inputCharArr.length; currentIndex++) {

			charSetTemp.remove(inputCharArr[currentIndex]);

			if (charSetTemp.isEmpty()) {

				String candidateString = s.substring(prevIndex, currentIndex + 1);
				String actualShortestString = removeStratingAndTrailingDuplicates(candidateString);

				if (actualShortestString.length() < outputString.length()) {
					outputString = actualShortestString;
					prevIndex = currentIndex;
					charSetTemp = new HashSet<Character>(charSet);
					continue;
				}

			}

		}

		return outputString;
	}

	private static String removeStratingAndTrailingDuplicates(String candidateString) {
		int stratIndex = 0;
		int endIndex = candidateString.length() - 1;

		int i = stratIndex + 1;
		while (candidateString.charAt(i) == candidateString.charAt(stratIndex) && i < candidateString.length()) {
			i++;
		}
		stratIndex = i - 1;

		int j = endIndex - 1;
		while (candidateString.charAt(j) == candidateString.charAt(endIndex) && j >= 0) {
			j--;
		}
		endIndex = j + 1;

		return candidateString.substring(stratIndex, endIndex + 1);
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_cases = Integer.parseInt(br.readLine());
		String[] outputs = new String[test_cases];
		int count = 0;

		while (count < test_cases) {

			String inputString = br.readLine();

			outputs[count] = getShortestSubString(inputString);
			count++;
		}

		for (String output : outputs) {
			System.out.println(output);
		}
		br.close();

	}
}
