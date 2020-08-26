/**
 * @author Ravi.Katiyar
 *
 *Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 *Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 *Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 * 
 */
package in.ravi.practice.grokking.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsOfPattern {
	
	public static void main(String args[]) {
		String str = "pppqp";
		String pattern = "pq";
		List<Integer> result = findStringAnagrams(str, pattern);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	
	public static List<Integer> findStringAnagrams(String str, String pattern) {
		List<Integer> resultIndices = new ArrayList<Integer>();
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			frequencyMap.put(pattern.charAt(i), frequencyMap.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		int left = 0;
		int right = -1;
		int matched = 0;

		while (right < str.length() - 1) {
			right++;
			if (frequencyMap.containsKey(str.charAt(right))) {
				char rightChar = str.charAt(right);

				int rightCharUpdatedValue = frequencyMap.get(rightChar) - 1;
				frequencyMap.put(rightChar, rightCharUpdatedValue);
				if (rightCharUpdatedValue == 0) {
					matched++;
				}
				if (matched == frequencyMap.size()) {
					resultIndices.add(left);
				}
			}

			if ((right - left) + 1 == pattern.length()) {
				char leftChar = str.charAt(left);
				int leftCharValue = frequencyMap.get(leftChar);
				if (leftCharValue == 0) {
					matched--;
				}
				frequencyMap.put(leftChar, leftCharValue + 1);
				left++;
			}
		}

		return resultIndices;
	}

}


