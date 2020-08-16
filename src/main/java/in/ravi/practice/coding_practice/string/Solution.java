/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 25-Nov-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             25-Nov-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static Map<Character, Integer> weights = new HashMap<Character, Integer>(40);
	static {
		weights.put('a', 1);
		weights.put('b', 2);
		weights.put('c', 3);
		weights.put('d', 4);
		weights.put('e', 5);
		weights.put('f', 6);
		weights.put('g', 7);
		weights.put('h', 8);
		weights.put('i', 9);
		weights.put('j', 10);
		weights.put('k', 11);
		weights.put('l', 12);
		weights.put('m', 13);
		weights.put('n', 14);
		weights.put('o', 15);
		weights.put('p', 16);
		weights.put('q', 17);
		weights.put('r', 18);
		weights.put('s', 19);
		weights.put('t', 20);
		weights.put('u', 21);
		weights.put('v', 22);
		weights.put('w', 23);
		weights.put('x', 24);
		weights.put('y', 25);
		weights.put('z', 26);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(bufferedReader.readLine());
		List<String> outputs = new ArrayList<String>();
		for (int i = 0; i < testCases; i++) {
			int stringCount = Integer.parseInt(bufferedReader.readLine());
			List<String> inputStrings = new ArrayList<String>();
			for (int j = 0; j < stringCount; j++) {
				inputStrings.add(bufferedReader.readLine());
			}

			Map<Integer, Integer> stringWeights = getStringWeights(inputStrings);
			int res = getInvalidStringPos(stringWeights);
			outputs.add(inputStrings.get(res));

			

		}

		// String result = Result.compressedString(message);

		// bufferedWriter.write(result);

		for (String output : outputs) {
			System.out.println(output);
		}

		bufferedReader.close();

	}

	private static Map<Integer, Integer> getStringWeights(List<String> inputStrings) {

		Map<Integer, Integer> stringWeights = new HashMap<Integer, Integer>();

		int pos = 0;
		for (String inputString : inputStrings) {
			int res = 0;
			for (char c : inputString.toCharArray()) {
				res += weights.get(c);
			}
			stringWeights.put(pos++, res);
		}

		return stringWeights;

	}

	private static int getInvalidStringPos(Map<Integer, Integer> stringWeights) {

		int resPos = -1;
		int sum = 0;
		for (int val : stringWeights.values()) {
			sum += val;
		}

		int meanVal = sum / stringWeights.size();

		int minDev = 999999;

		for (Map.Entry<Integer, Integer> entry : stringWeights.entrySet()) {

			if (Math.abs(entry.getValue() - meanVal) < minDev) {
				minDev = Math.abs(entry.getValue() - meanVal);
				resPos = entry.getKey();
			}
		}

		return resPos;
	}
}
