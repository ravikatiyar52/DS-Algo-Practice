/**
 * @author Ravi.Katiyar
 *
 *Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 *Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
 *
 * 
 */
package in.ravi.practice.grokking.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringDistinctChar {

	public static void main(String args[]) {
		String input = "abcac";
		int k = 2;
		int output = findLength(input, k);

		System.out.println(output);
	}

	public static int findLength(String str, int k) {
		Map<Character, Integer> distinctCharMap = new HashMap<Character, Integer>();
		int longestSubStringLength = 1;
		int start = 0;
		int end = 0;
		addToMap(str.charAt(end), distinctCharMap);
		while (start <= end && end < str.length() - 1) {
			end++;
			addToMap(str.charAt(end), distinctCharMap);
			if (distinctCharMap.size() <= k) {
				int currentSubStringLength = (end - start) + 1;
				if (currentSubStringLength > longestSubStringLength) {
					longestSubStringLength = currentSubStringLength;
				}
			} else {
				while (distinctCharMap.size() > k) {
					removeFromMap(str.charAt(start), distinctCharMap);
					start++;
				}
			}

		}
		return longestSubStringLength;
	}

	private static void addToMap(char c, Map<Character, Integer> distinctCharMap) {
		Integer presentValue = distinctCharMap.get(c);
		if (presentValue == null) {
			distinctCharMap.put(c, 1);
		} else {
			distinctCharMap.put(c, presentValue + 1);
		}
	}

	private static void removeFromMap(char c, Map<Character, Integer> distinctCharMap) {
		Integer presentValue = distinctCharMap.get(c);
		if (presentValue != null) {
			Integer newValue = presentValue - 1;
			if (newValue > 0) {
				distinctCharMap.put(c, newValue);
			} else {
				distinctCharMap.remove(c);
			}
		}
	}

}


