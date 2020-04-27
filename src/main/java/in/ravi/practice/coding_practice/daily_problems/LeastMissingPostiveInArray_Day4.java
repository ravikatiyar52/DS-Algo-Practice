/**
 * @author Ravi.Katiyar
 *This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
 *
 * 
 */
package in.ravi.practice.coding_practice.daily_problems;

/**
 * 
 * We will again use the technique to use array element as indexes to mark a
 * presence of element by changing the sign of the element at that array value
 * index.
 * 
 * But this technique doesn't work when there are -ve numbers in array so we
 * will first seperate -ve and +ve numbers then on the array with only positive
 * numbers we can use this technique.
 * 
 * So we will implement two methods one for separation of -ve and +ve numbers
 * and other two find the first missing number.
 *
 * 
 */
public class LeastMissingPostiveInArray_Day4 {

	/**
	 * This method will separate -ve and +ve numbers from array and will return the
	 * 1st index in the array from where positive number starts
	 * 
	 * @return
	 */
	public int seperatePositiveInArray(int[] arr) {

		int j = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				j = j + 1;
				swap(arr, i, j);
			}
		}

		return j + 1;

	}

	// utility swap method
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public int updateArrayAndFindLeastMissingPositive(int arr[]) {
		int missing_positive = 0;

		// first mark the presence using -ve sign technique
		for (int i = 0; i < arr.length; i++) {
			int element_at_index = arr[i] ;
			if (element_at_index < arr.length && Math.abs(element_at_index) < arr.length && arr[Math.abs(element_at_index)] >= 0) {
				arr[Math.abs(element_at_index)] = -arr[Math.abs(element_at_index)];
			}
		}

		int i = 0;
		for ( ;i < arr.length; i++) {
			if (arr[i] > 0 && i!=0) {
				missing_positive = i ;
				break;
			}else if( i >= missing_positive) {
				missing_positive = i+1;
			}
		}
		
		
		

		return missing_positive;

	}

	/*public int getLeastMissingPositive(int input[]) {

		
		LeastMissingPostiveInArray_Day4 leastMissingPostiveInArray_Day4 = new LeastMissingPostiveInArray_Day4();
		int positive_seperator_index = leastMissingPostiveInArray_Day4.seperatePositiveInArray(input);

		int new_array_length = input.length - positive_seperator_index;

		int positive_array[] = new int[new_array_length];

		int j = 0;
		for (int i = positive_seperator_index; i < input.length; i++) {
			positive_array[j++] = input[i];
		}

		int least_missing_positive = leastMissingPostiveInArray_Day4.updateArrayAndFindLeastMissingPositive(positive_array);
		
		return least_missing_positive;
	}
*/
}
