/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 25-Jun-2019
 */
package in.ravi.practice.coding_practice.string;

import java.util.ArrayList;
import java.util.List;

public class AllSubStringGenerator {

	static List<String> allSubstrings = new ArrayList<String>();
	static String inputStr = "abc";

	static void generateSubStringOfLength(int n) {

		int startIndex = 0;
		int endIndex = n;

		while (endIndex <= inputStr.length()) {
			allSubstrings.add(inputStr.substring(startIndex, endIndex));
			startIndex++;
			endIndex++;
		}

	}

	public static void main(String args[]) {

		for (int i = 1; i <= inputStr.length(); i++) {
			generateSubStringOfLength(i);
		}

		for (String subString : allSubstrings) {
			System.out.println(subString);
		}
	}

}
