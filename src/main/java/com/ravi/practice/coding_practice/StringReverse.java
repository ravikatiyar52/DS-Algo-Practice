package com.ravi.practice.coding_practice;

import java.util.Scanner;

public class StringReverse {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int number_test_cases = scanner.nextInt();
	
		String[] inputs = new String[number_test_cases];

		for (int i = 0; i < number_test_cases; i++) {
			inputs[i] = scanner.next();
		}

		for (String input : inputs) {
			String reverse = reverseString(input);
			System.out.println(reverse);
		}
		scanner.close();
	}

	private static String reverseString(String input) {

		char[] inputCharArray = input.toCharArray();
		int start = 0;
		int end = inputCharArray.length - 1;

		while (start < end) {
			char temp = inputCharArray[start];
			inputCharArray[start] = inputCharArray[end];
			inputCharArray[end] = temp;
			start++;
			end--;
		}

		return new String(inputCharArray);
	}
}
