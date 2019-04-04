/**
 * @author Ravi.Katiyar
 *
 Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed. 
 */
package in.ravi.practice.coding_practice.daily_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Ravi.Katiyar
 *
 *Refer the explanation here
 * https://www.youtube.com/watch?v=qli-JCrSwuk&t=823s
 * 
 *
 */
public class MessageDecoding_day7 {

	public static int num_decodes(String message, int k, int memoization[]) {

		if (k == 0) {
			return 1;
		}
		int firstIndex = message.length() - k;

		if (message.charAt(firstIndex) == '0') {
			return 0;
		}

		if (memoization[k] != -1) {
			return memoization[k];
		}

		int result = num_decodes(message, k - 1, memoization);

		if (k >= 2) {
			String firstTwoCharacter = message.substring(firstIndex, firstIndex + 2);
			if (Integer.parseInt(firstTwoCharacter) <= 26) {
				result += num_decodes(message, k - 2, memoization);
			}
		}
		memoization[k] = result;

		return result;

	}

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		List<Integer> outputs = new ArrayList<Integer>();

		int testCase = 1;
		while (testCase <= numberOfTestCases) {

			int messageLength = scanner.nextInt();
			// int messageInt = scanner.nextInt();
			String message = scanner.nextLine();
			message = scanner.nextLine();
			// int output = getDecodedMessagesCountgfg(message, messageLength);
			int[] memoization = new int[messageLength + 1];
			for (int i = 0; i < memoization.length; i++) {
				memoization[i] = -1;
			}
			int output = num_decodes(message, messageLength, memoization);
			outputs.add(output);
			testCase++;
		}
		for (int output : outputs) {
			System.out.println(output);
		}
		scanner.close();

	}
}
