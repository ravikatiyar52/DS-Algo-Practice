/**
 * @author Ravi.Katiyar
 *
 
 * 
 */
package in.ravi.practice.coding_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GeeksForGeeksInput {

	
	public void readInput() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_cases = Integer.parseInt(br.readLine());
		int[] outputs = new int[test_cases];
		int count = 0;

		while (count < test_cases) {
			int array_size = Integer.parseInt(br.readLine());
			int input[] = new int[array_size];

			String arrString = br.readLine();
			int i = 0;
			for (String token : arrString.split(" ")) {
				input[i++] = Integer.parseInt(token);
			}

			outputs[count] = 0;
			count++;
		}

		for (int output : outputs) {
			System.out.println(output);
		}
		br.close();
	}
}


