/**
 * @author Ravi.Katiyar
 */
package in.ravi.practice.grokking.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Ravi.Katiyar
 *
 ** 
 * 
 *         Given a string and a list of words, find all the starting indices of
 *         substrings in the given string that are a concatenation of all the
 *         given words exactly once without any overlapping of words. It is
 *         given that all words are of the same length.
 * 
 *         Input: String="catfoxcat", Words=["cat", "fox"] Output: [0, 3]
 *         Explanation: The two substring containing both the words are "catfox"
 *         & "foxcat".
 * 
 * 
 *         Input: String="catcatfoxfox", Words=["cat", "fox"] Output: [3]
 *         Explanation: The only substring containing both the words is
 *         "catfox".
 * 
 *
 */
public class WordConcatenation9 {
	
	public static void main(String args[]) {
		String str = "catfoxcat";
		String [] words = {"cat","fox"};
		
		List<Integer> results = findWordConcatenation(str, words);
		for(int result:results) {
			System.out.print(result + " ");
		}
	}

	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> resultIndices = new ArrayList<Integer>();

		Map<String, Integer> wordFreqMap = new HashMap<String, Integer>();
		// maintain each word along with their occurrence count in a HashMap.
		for (String word : words) {
			wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
		}
		int eachWordLength = words[0].length();
		int totalWords = words.length;
		int requiredSubStringLength = eachWordLength * totalWords;

		if (str.length() < requiredSubStringLength) {
			return resultIndices;
		}

		for (int i = 0; i <= str.length() - requiredSubStringLength; i++) {
			int totalWordsFound = 0;
			Map<String, Integer> wordFreqMapTemp = new HashMap<String, Integer>(wordFreqMap);

			int j = i;
			while (j <= i + requiredSubStringLength - eachWordLength) {

				String currentWord = str.substring(j, j+eachWordLength);

				// if this word is not found or is having higher frequency then required
				if (!wordFreqMapTemp.containsKey(currentWord) || wordFreqMapTemp.get(currentWord) == 0) {
					break;
				}

				wordFreqMapTemp.put(currentWord, wordFreqMapTemp.get(currentWord) - 1);
				totalWordsFound++;
				j = j + eachWordLength;
			}
			if (totalWordsFound == wordFreqMap.size()) {
				resultIndices.add(i);
			}
		}

		return resultIndices;

	}

}
