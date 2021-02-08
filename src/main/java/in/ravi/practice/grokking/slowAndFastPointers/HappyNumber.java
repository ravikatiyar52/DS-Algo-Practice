/**
 * @author Ravi.Katiyar
 *
 *Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
 * All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’
 * 
 * 
 */
package in.ravi.practice.grokking.slowAndFastPointers;

public class HappyNumber {

	/**
	 * Both happy and non happy numbers loop back.
	 * Happy number loop back to 1 and non happy numbers loop back to some number other than 1.
	 * So we will use fast and slow pointer approach and if fast and slow pointer meet at 1 the number is happy else not happpy. 
	 * @param num
	 * @return
	 */
	public static boolean find(int num) {

		int slow = num;
		int fast = num;

		do {
			slow = getSquareSumOfDigits(slow);
			fast = getSquareSumOfDigits(getSquareSumOfDigits(fast));
		} while (slow != fast);

		if(slow == 1)
			return true;
		else
			return false;
	}
	
	
	
	private static int getSquareSumOfDigits(int num) {
		int squareSum =0 ;
		
		while(num > 0) {
			int digit = num % 10;
			squareSum += Math.pow(digit, 2);
			num = num/10;
		}
		
		return squareSum;
	}
	
	public static void main(String[] args) {
	    System.out.println(HappyNumber.find(23));
	    System.out.println(HappyNumber.find(12));
	  }
}


