package in.ravi.practice.coding_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArrayRearrange {

	public static void main(String args[]) throws NumberFormatException, IOException {

		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		// Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(bufferedReader.readLine());
		List<Integer[]> outputs = new ArrayList<Integer[]>(testCases);
		for (int i = 0; i < testCases; i++) {

			int arraySize = Integer.parseInt(bufferedReader.readLine());
			Integer a[] = new Integer[arraySize];
			String arrayAsString = bufferedReader.readLine();
			int j = 0;
			for (String str : arrayAsString.split(" ")) {
				a[j] = Integer.parseInt(str);
				j++;
			}

			arrangeArray(a, a.length);
			outputs.add(a);
		}
		bufferedReader.close();
		inputStreamReader.close();
		for (Integer[] output : outputs) {
			for (Integer element : output) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static Integer[] arrangeArray(Integer[] a, int length) {

		int i = 0;

		while (i < length) {

			if (a[i] == i) {
				i++;
			} else {
				if (validIndex(a[i], length)) {
					swap(a, i, a[i]);
					if (a[i] >= 0 && a[i] < i) {
						i = a[i];
					} else {
						i++;
					}
				} else {
					a[i] = -1;
					i++;
				}
			}
		}

		return a;
	}

	public static boolean validIndex(int index, int length) {

		return (index <= length - 1 && index >= 0);
	}

	public static void swap(Integer a[], int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
