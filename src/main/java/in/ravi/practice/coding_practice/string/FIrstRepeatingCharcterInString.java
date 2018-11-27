package in.ravi.practice.coding_practice.string;

public class FIrstRepeatingCharcterInString {

	// input String geeksforgeeks
	// output g first occurence is leftmost
	//traverse the string only once

	public static void main(String args[]) {

		String inputString = "geeksforgeeks";
		int[] allCharactersArray = new int[256];

		for (int i = 0; i < allCharactersArray.length; i++) {
			allCharactersArray[i] = -1;
		}
		boolean found = false;
		for (char c : inputString.toCharArray()) {

			if (allCharactersArray[c] == -1) {
				allCharactersArray[c] = c;
			} else {
				found = true;
				System.out.println("first repeating character is " + c);
				break;
			}

		}

		if (!found) {
			System.out.println("no repeating character");
		}
	}
}
