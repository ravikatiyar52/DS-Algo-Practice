/**
 * @author Ravi.Katiyar
 *
 
 */
package in.ravi.practice.coding_practice.string;

import java.util.HashMap;
import java.util.Map;

public class DictionarySum {
	
	public static void main(String args[]) {
		
		int [] result = getFirstDictionaryWord(1, 5);
		
		Map<Integer, Character> dictionaryMap = new HashMap<Integer, Character>();
		dictionaryMap.put(1, 'a');
		dictionaryMap.put(2, 'b');
		dictionaryMap.put(3, 'c');
		dictionaryMap.put(4, 'd');
		dictionaryMap.put(5, 'e');
		dictionaryMap.put(6, 'f');
		dictionaryMap.put(7, 'g');
		dictionaryMap.put(8, 'h');
		dictionaryMap.put(9, 'i');
		dictionaryMap.put(10, 'j');
		dictionaryMap.put(11, 'k');
		dictionaryMap.put(12, 'l');
		dictionaryMap.put(13, 'm');
		dictionaryMap.put(14, 'n');
		dictionaryMap.put(15, 'o');
		dictionaryMap.put(16, 'p');
		dictionaryMap.put(17, 'q');
		dictionaryMap.put(18, 'r');
		dictionaryMap.put(19, 's');
		dictionaryMap.put(20, 't');
		dictionaryMap.put(21, 'u');
		dictionaryMap.put(22, 'v');
		dictionaryMap.put(23, 'w');
		dictionaryMap.put(24, 'x');
		dictionaryMap.put(25, 'y');
		dictionaryMap.put(26, 'z');
		
		for(int k : result) {
			System.out.print(dictionaryMap.get(k));
		}
		
	}
	

	private static int[] getFirstDictionaryWord(int length, int requiredSum) {

		int[] firstDictioanryWord = new int[length];

		for (int i = 0; i < firstDictioanryWord.length; i++) {
			firstDictioanryWord[i] = 1;
		}

		int position = firstDictioanryWord.length - 1;
		int currentSum = firstDictioanryWord.length;
		while (position >= 0 && currentSum < requiredSum) {

			int remainingSum = requiredSum - currentSum;
			if (remainingSum > 26) {
				firstDictioanryWord[position] = 26;
				currentSum += 25;
				position--;
			} else {
				firstDictioanryWord[position] = remainingSum+1;
				currentSum += remainingSum+1;
			}

		}

		return firstDictioanryWord;
	}

	private static double maxPossibleSum(double length) {

		return Math.pow(27, length);
	}
}
