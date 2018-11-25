package com.ravi.practice.coding_practice.string;

public class FirstNonRepeatingCharacter {
	// input geeksforgeeks , output = f
	// input abab, output f

	public static void main(String args[]) {

		String inputString = "geeksforgeeks";
		int[] allCharactersArray = new int[256];

		for (int i = 0; i < allCharactersArray.length; i++) {
			allCharactersArray[i] = -1;
		}

		/*for (char c : inputString.toCharArray()) {
			
		}*/

		boolean found = false;
		for (char c : inputString.toCharArray()) {

			if (allCharactersArray[c] < c && allCharactersArray[c] != -1) {
				System.out.println(c);
				found = true;
				break;
			}else {
				allCharactersArray[c] += c;	
			}

		}

		if (!found) {
			System.out.println(-1);
		}
	}

}
