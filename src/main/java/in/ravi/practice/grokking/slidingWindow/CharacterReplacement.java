
package in.ravi.practice.grokking.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ravi.Katiyar
 * 
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement
 *
 * Input: String="aabccbb", k=2
   Output: 5
   Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
*
*Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
*
*
*Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
*
* 
*/
public class CharacterReplacement {

	
	/**
	 * Length of the longest substring having the same letters after replacement can be achieved by finding a window with most repeating characters and no more than k distinct characters.
	 * Because then we can replace the K distinct characters with the most repeating character in that window to form the longest substring with same letters.
	 * Using the sliding window pattern. We keep sliding the window by stretching the end.
	 * Now here's the trick : 
	 * To ensure we have don't have more than K distinct character in our window we will subtract the frequency of the most repeating character from the total length of this window.
	 * We will maintain a character frequency as we slide and just when we see that we have more than k distinct characters inside the window we will shrink the window from start
	 * and of course as we shrink we decrement the frequency of the character removed from the window. 
	 * @param str
	 * @param k
	 * @return
	 */
	public static int findLength(String str, int k) {
		int start = 0;
		int end = -1;
		int maximumRepeatingCharLength = 0;
		int maxWindowLength = 0;
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		while (end < str.length() - 1) {
			end++;
			frequencyMap.put(str.charAt(end), frequencyMap.getOrDefault(str.charAt(end), 0) + 1);
			maximumRepeatingCharLength = Math.max(maximumRepeatingCharLength, frequencyMap.get(str.charAt(end)));

			// Check if we need to shrink.ie if there are more than K distinct characters in
			// this window just remove one from start
			if ((end - start) + 1 - maximumRepeatingCharLength > k) {
				frequencyMap.put(str.charAt(start), frequencyMap.get(str.charAt(start)) - 1);
				start++;
			}
			maxWindowLength = Math.max(maxWindowLength, (end - start) + 1);
		}
		return maxWindowLength;
	}
	
	
}


