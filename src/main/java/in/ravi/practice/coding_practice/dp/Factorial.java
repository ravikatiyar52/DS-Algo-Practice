/**
 * @author Ravi.Katiyar
 * 
 */
package in.ravi.practice.coding_practice.dp;

public class Factorial {
	
	
	public static void main(String args[]) {
		
		System.out.println(getFactorial(1));
	}

	public static int getFactorial(int n) {

		int computed[] = new int[n+1];
		for (int index = 0; index < computed.length; index++) {
			computed[index] = -1;
		}
		return getFactorialUtil(computed, n);
	}

	public static int getFactorialUtil(int[] computed, int n) {

		if (computed[n] != -1) {
			return computed[n];
		} else {
			if (n == 1) {
				computed[n] = 1;
			} else {
				computed[n] = n * getFactorialUtil(computed, n - 1);
			}
			return computed[n];
		}

	}

}
