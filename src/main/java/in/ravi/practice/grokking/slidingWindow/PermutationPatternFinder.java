/**
 * @author Ravi.Katiyar
 *
 */
package in.ravi.practice.grokking.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * 
 *  Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
 *
 */
public class PermutationPatternFinder {

	public static void main(String args[]) {
		String input = "bcdxabcdy";
		String pattern = "bcdyabcdx";
		System.out.println(findPermutation(input, pattern));
	}
	
	public static boolean findPermutation(String str, String pattern) {
		boolean found = false;
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			freqMap.put(pattern.charAt(i), freqMap.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		int left = 0;
		int right = -1;
		int matched = 0;

		while (right < str.length() -1  && !found) {
			right++;
			char rightChar = str.charAt(right);

			if (freqMap.containsKey(rightChar)) {
				freqMap.put(rightChar, freqMap.get(rightChar) - 1);

				if (freqMap.get(rightChar) == 0) {
					matched++;
				}

			}

			// if length of window > patten_length shrink the window
			if ((right - left + 1) > pattern.length()) {
				char leftChar = str.charAt(left);

				if (freqMap.containsKey(leftChar)) {
					// if a char that was matched is going out of the window , our matched count has
					// now reduced by 1
					if (freqMap.get(leftChar) == 0) {
						matched--;
					}
					// put the character back in map
					freqMap.put(leftChar, freqMap.get(leftChar) + 1);
				}
				left++;
			}
			if (matched == freqMap.size() && (right - left +1)==pattern.length()) {
				found = true;
				break;
			}
		}
		return found;
	}
}


