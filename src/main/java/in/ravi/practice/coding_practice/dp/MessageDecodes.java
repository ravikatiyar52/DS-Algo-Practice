/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 11-Nov-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             11-Nov-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageDecodes {
	
	public static void main(String args[]) {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(bufferedReader.readLine());
			int outputs[] = new int[testCases];
			
			for(int i=0;i<testCases;i++) {
				int messageLength = Integer.parseInt(bufferedReader.readLine());
				String message = bufferedReader.readLine();
				outputs[i] = getDecodes(message,messageLength);
			}
			
			for(int i =0 ; i<outputs.length;i++ ) {
				System.out.println(outputs[i]);
			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static int getDecodes(String message, int messageLength) {
		if(validMessage(message)) {
			int index_results[] = new int[messageLength];
			index_results[0] = 1;
			
			for(int i = 1 ; i<message.length();i++) {
				
				int current_digit = Integer.parseInt(message.substring(i-1, i+1));
				if(current_digit % 10 == 0 && current_digit > 20) {
					return 0;
				}
				if(current_digit < 26 && i == 1) {
					index_results[i] = 2;
				}else if(current_digit <= 26 && i > 1) {
					index_results[i] = index_results[i-1] + 2; 
				}else {
					index_results[i] = index_results[i-1];
				}
				
			}
			
			return index_results[index_results.length-1];
			
		}else {
			return 0;
		}
		
	}

	private static boolean validMessage(String message) {
		
		boolean valid = true;
		
		if(message.startsWith("0") || 
				message.contains("00") || 
				message.length() < 1) {
			valid = false;
		}
		
		return valid;
		
	}

}


