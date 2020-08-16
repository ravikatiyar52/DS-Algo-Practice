/**
 * @author Ravi.Katiyar 
 * 
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ&t=1358s
 */
package in.ravi.practice.coding_practice.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1. create two arrays character and count Array, the corresponding indexes  of these two array represent characters of given string and its occurrence count. 
 * 2. iterate the given string from left to right
 * 3. look for first character which is not used (not used means count > 0) 
 * 4. put the unused character in the result array at index == current recursion depth(passed as level argument) 
 * 5. mark this character as used and recurse from here incrementing the level 
 * 6. once we return from recursion we mark that character as unused
 */
public class StringPermutation {

	private static int[] charCount;
	private static char[] characters;

	public static void main(String args[]) {
		String input = args[0];
		getCharCountArray(input);
		char[] permutation = new char[input.length()];
		permuteUtil(input, permutation, charCount, 0);
	}

	private static void permuteUtil(String input, char[] permutation, int[] charCount, int level) {
		if (level == input.length()) {
			printArray(permutation);
			return;
		}

		for (int i = 0; i < charCount.length; i++) {
			if (charCount[i] == 0) {
				continue;
			}
			permutation[level] = characters[i];
			charCount[i] = charCount[i] - 1;
			permuteUtil(input, permutation, charCount, level + 1);
			charCount[i] = charCount[i] + 1;
		}
	}

	private static void printArray(char[] str) {
		for (char c : str) {
			System.out.print(c);
		}
		System.out.println();
	}

	private static int[] getCharCountArray(String input) {
		Map<Character, Integer> characterCountMap = new LinkedHashMap<Character, Integer>();
		for (char c : input.toCharArray()) {
			Integer currentCount = characterCountMap.get(c);
			int updatedCount = 0;
			if (null != currentCount) {
				updatedCount = currentCount + 1;
			} else {
				updatedCount = 1;
			}
			characterCountMap.put(c, updatedCount);
		}
		Set<Character> keys = characterCountMap.keySet();
		charCount = new int[keys.size()];
		characters = new char[keys.size()];
		int i = 0;
		for (char key : keys) {
			charCount[i] = characterCountMap.get(key);
			characters[i] = key;
			i++;
		}
		return charCount;

	}
}
