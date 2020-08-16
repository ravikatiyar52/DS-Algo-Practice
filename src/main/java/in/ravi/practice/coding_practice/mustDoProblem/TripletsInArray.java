/**
 * @author Ravi.Katiyar
 *
 *https://www.geeksforgeeks.org/count-triplets-such-that-one-of-the-numbers-can-be-written-as-sum-of-the-other-two/
 *
 *Given an array A[] of N integers. 
 *The task is to find the number of triples (i, j, k) , where i, j, k are indices and (1 <= i < j < k <= N), 
 *such that in the set { A_i, A_j, A_k} at least one of the numbers can be written as the sum of the other two
 *
 * Input : A[] = {1, 2, 3, 4, 5}
Output : 4
The valid triplets are:
(1, 2, 3), (1, 3, 4), (1, 4, 5), (2, 3, 5)

Input : A[] = {1, 1, 1, 2, 2}
Output : 6
 * 
 * 
 * Answer : 
 * 1. Looking at the problem closely we can realize that the problem is asking to count the combination of all indexes that form triplet 
 * and not the combination of numbers in the array
 * 
 * 2. For example assume that there are 4 zeros in the array at indexes 1,2,4,6 Now any combination of zero will be a triplet because 0 + 0 = 0.
 * if we were counting the combination of numbers then because of zeros there would be just 1 combination (0,0,0) but we are counting index combination
 * so such combination will be (4c3) which are (1,2,4) (1,2,6) (2,4,6) (1,4,6).
 * 
 * Overall : 
 * 
 *  we will calculate frequency of every number in array let call it f(x)
 *  
 *  then 
 * 
 * There exist four cases:
All three numbers are equal to 0. The number of ways = f(0)C3 (where pCq is the number of ways of choosing q numbers from p numbers).
One number is equal to 0, the other two are equal to some x > 0: f(0) * f(x)C2.
Two numbers are equal to some x>0, the third is 2*x: f(x)C2 * f(2 * x).
The three numbers are x, y and x + y, 0 < x, y: f(x) * f(y) * f(x + y).
 * 
 * 
 */
package in.ravi.practice.coding_practice.mustDoProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import in.ravi.practice.coding_practice.dp.Factorial;

public class TripletsInArray {

	public static void main(String args[]) {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String testCasesStr = bufferedReader.readLine();
			int testCases = Integer.parseInt(testCasesStr);
			int testCasesRead = 0;
			List<Integer> outputs = new ArrayList<Integer>();

			while (testCasesRead < testCases) {
				String inputSizeStr = bufferedReader.readLine();
				int inputSize = Integer.parseInt(inputSizeStr);
				int[] inputArray = new int[inputSize];
				String inputArrayAsString = bufferedReader.readLine();
				int index = 0;
				for (String key : inputArrayAsString.split(" ")) {
					inputArray[index++] = Integer.parseInt(key);
				}
				int output = countTriplets(inputArray);
				outputs.add(output);
				testCasesRead++;
			}

			for (int output : outputs) {
				System.out.println(output);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("something went wrong ");
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static int countTriplets(int[] inputArray) {
		// TODO Auto-generated method stub

		// create a frequency map
		Map<Integer, Integer> freqMap = getFreqMap(inputArray);
		Set<Integer> distinctNumbers = freqMap.keySet();
		int[] distinctNumbersArr = new int[distinctNumbers.size()];
		int index = 0;
		for (int number : distinctNumbers) {
			distinctNumbersArr[index++] = number;
		}
		int totalTripletCombination = 0;

		// case 1 (0,0,0)
		Integer zeroFreq = freqMap.get(0);
		if (null != zeroFreq) {
			totalTripletCombination = (totalTripletCombination + getCombinations(zeroFreq, 3));
		}
		// case 2 (0,x,x)
		if (null != zeroFreq) {
			for (int element : distinctNumbersArr) {
				if (element != 0) {
					Integer freq = freqMap.get(element);
					if (null != freq) {
						totalTripletCombination += (zeroFreq * getCombinations(freq, 2));
					}
				}
			}
		}

		// case 3 (x,x,2x)
		for (int element : distinctNumbersArr) {
			if (element != 0) {
				Integer freq = freqMap.get(element);
				Integer twiceFreq = freqMap.get(2 * element);
				if (null != freq && null != twiceFreq) {
					totalTripletCombination += (getCombinations(freq, 2) * twiceFreq);
				}
			}
		}

		// case 4 (x,x,x+y)
		for (int i = 0; i < distinctNumbersArr.length; i++) {
			for (int j = i + 1; j < distinctNumbersArr.length; j++) {
				if (inputArray[i] != 0 && inputArray[j] != 0) {
					Integer firstElementFreq = freqMap.get(distinctNumbersArr[i]);
					Integer secondElementFreq = freqMap.get(distinctNumbersArr[j]);
					Integer sumElementFreq = freqMap.get(distinctNumbersArr[i] + distinctNumbersArr[j]);
					if (null != firstElementFreq && null != secondElementFreq && null != sumElementFreq) {
						totalTripletCombination += (firstElementFreq * secondElementFreq * sumElementFreq);
					}
				}
			}
		}

		return totalTripletCombination;
	}

	private static int getCombinations(int n, int r) {
		if (n < r) {
			return 0;
		}
		return Factorial.getFactorial(n) / (Factorial.getFactorial(r) * Factorial.getFactorial(n - r));
	}

	private static Map<Integer, Integer> getFreqMap(int[] input) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		for (int element : input) {
			Integer value = freqMap.get(element);
			if (null == value) {
				value = 1;
			} else {
				value = value + 1;
			}
			freqMap.put(element, value);
		}
		return freqMap;
	}

}
