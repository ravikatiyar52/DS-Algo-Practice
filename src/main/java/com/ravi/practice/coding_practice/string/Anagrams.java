package com.ravi.practice.coding_practice.string;

public class Anagrams {

	public static void main(String args[]) {

		String s1 = "geek";
		String s2 = "emek";

		boolean anagram = isAnagram(s1, s2);
		System.out.println(anagram);
	}

	private static boolean isAnagram(String s1, String s2) {

		return (stringAsciSum(s1) == stringAsciSum(s2));
	}

	private static int stringAsciSum(String s1) {
		int sum = 0;
		for (char c : s1.toCharArray()) {
			sum += c;
		}
		return sum;
	}
}
