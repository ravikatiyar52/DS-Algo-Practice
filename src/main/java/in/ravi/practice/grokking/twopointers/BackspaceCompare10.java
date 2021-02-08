/**
 * @author Ravi.Katiyar
 *
 *Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 *Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 * 
 * 
 */
package in.ravi.practice.grokking.twopointers;

public class BackspaceCompare10 {
	
	public static void main(String args[]) {
		System.out.println(compare("xy#z", "xzz#"));
		System.out.println(compare("xy#z", "xyz#"));
		System.out.println(compare("xp#", "xyz##"));
		System.out.println(compare("xywrrmp", "xywrrmu#p"));
	}

	
	public static boolean compare(String str1, String str2) {
	    
		boolean result = true;
		int str1Pointer = str1.length() - 1;
		int str2Pointer = str2.length() - 1;
		
		while (str1Pointer >= 0 || str2Pointer >= 0) {
			
			str1Pointer = str1Pointer - (2 * getCharsToRemove(str1, str1Pointer));
			str2Pointer = str2Pointer - (2 * getCharsToRemove(str2, str2Pointer));
			
			//reached the end of both string
			if(str1Pointer < 0 && str2Pointer < 0) {
				return true;
			}
			
			//1 string is finished but other is left then return false
			if((str1Pointer < 0 && str2Pointer >= 0) || (str1Pointer >= 0 && str2Pointer < 0)) {
				return false;
			}
			
			if(str1.charAt(str1Pointer) != str2.charAt(str2Pointer)) {
				return false;
			}
			
			str1Pointer --;
			str2Pointer --;
		}
		
	    return result;
	  }

	private static int getCharsToRemove(String str, int strPointer) {
		int charsToRemove = 0;
			while(str.charAt(strPointer) == '#') {
				charsToRemove ++;
				strPointer --;
			}
		
		return charsToRemove;
	}
}


