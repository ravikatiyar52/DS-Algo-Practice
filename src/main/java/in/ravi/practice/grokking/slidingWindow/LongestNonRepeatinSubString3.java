/**
 * @author Ravi.Katiyar
 *
 *Given a string, find the length of the longest substring which has no repeating characters.
 *
 * Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
 * 
 * 
 * Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
 * 
 * 
 * Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */


package in.ravi.practice.grokking.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatinSubString3 {
	
	public static void main(String args[]) {
		String input = "acbdcefgh";
		System.out.println(findLength(input));
	}
	
	
	public static int findLength(String str) {
	   int start = 0;
	   int end =-1;
	   int maxLength = 0;
	   Set<Character> visitedCharacters = new HashSet<Character>();
	   while(end < str.length() - 1) {
		   end ++;
		   //if by adding this character we are not encountering any duplicate then just check if we have found a new max length by having end at this index
		   if(!visitedCharacters.contains(str.charAt(end))) {
			   visitedCharacters.add(str.charAt(end));
			   int currentLength = (end - start ) + 1;
			   maxLength = Math.max(maxLength, currentLength);
		   }else {	
			   //when we are in this else block it means the character at end index is the repeating character in the current window  
			   //now we want to move the start pointer one index ahead of the first occurrence of this duplicate character so that we are again in a window of no duplicate characters
			   while(str.charAt(start) != str.charAt(end)) {
				   visitedCharacters.remove(str.charAt(start));
				   start ++;
			   }
			   visitedCharacters.add(str.charAt(start));
			   start ++;
		   }
	   }   
	    return maxLength;
	  }
	
}


