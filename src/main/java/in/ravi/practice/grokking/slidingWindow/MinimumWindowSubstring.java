/**
 * @author Ravi.Katiyar
 * 
 */
package in.ravi.practice.grokking.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find the smallest substring in the given string
 * which has all the characters of the given pattern.
 * 
 * Input: String="aabdec", Pattern="abc" Output: "abdec" Explanation: The
 * smallest substring having all characters of the pattern is "abdec"
 * 
 * Input: String="abdabca", Pattern="abc" Output: "abc" Explanation: The
 * smallest substring having all characters of the pattern is "abc".
 * 
 * Input: String="adcad", Pattern="abc" Output: "" Explanation: No substring in
 * the given string has all characters of the pattern.
 */
public class MinimumWindowSubstring {
	
	public static void main(String args[]) {
		String str = "aabdec";
		String pattern = "abc";
		System.out.println(findSubstring(str, pattern));
	}
	
	public static String findSubstring(String str, String pattern) {
		String minimumSubString = "";
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

		for (int i = 0; i < pattern.length(); i++) {
			frequencyMap.put(pattern.charAt(i), frequencyMap.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		int start = 0;
		int end = -1;
		int minLength = Integer.MAX_VALUE;
		int matched = 0;

		while (end < str.length() - 1) {
			end++;
			char rightChar = str.charAt(end);
			if (frequencyMap.containsKey(rightChar)) {
				int rightCharUpdatedValue = frequencyMap.get(rightChar) - 1;
				if (rightCharUpdatedValue == 0) {
					matched++;
				}
				frequencyMap.put(rightChar, rightCharUpdatedValue);
				//lets try to shrink the window
				while (matched == frequencyMap.size()) {
					
					if((end-start) + 1 <minLength) {
						minLength = (end-start) + 1;
						minimumSubString = str.substring(start, end+1);
					}
					char leftChar = str.charAt(start);
					if(frequencyMap.containsKey(leftChar)) {
						int leftCharValue = frequencyMap.get(leftChar);
						if(leftCharValue == 0) {
							matched --;
						}
						frequencyMap.put(leftChar, leftCharValue + 1);
					}
					start ++;
				}
			}

		}

		return minimumSubString;
	}
	

}
