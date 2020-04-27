package in.ravi.practice.coding_practice.arrays;

/**
 * implement a binary search make sure to handle all boundary cases
 * 
 * @author Ravi.Katiyar
 *
 */
public class BinarySearch {

	public static void main(String args[]) {
		int a[] = { 1, 2, 3, 4, 5 };
		//int index_found = search(a, 0, a.length - 1, 4);
		int index_found = recursive_binary_search(a, 0, a.length - 1, 1);
		System.out.println("element found at index " + index_found);
	}

	/*public static int search(int a[], int low, int high, int search) {

		int index = -1;

		if (a.length == 1) {
			if (a[0] == search) {
				index = 0;
			}
		} else {
			while (low <= high) {

				int mid = (low + high) / 2;

				if (a[mid] == search) {
					index = mid;
					break;
				} else if (search > a[mid]) {
					low = mid + 1;

				} else {
					high = mid;
				}

			}
		}
		return index;
	}*/

	public static int recursive_binary_search(int a[], int low, int high, int key) {

		// base case
		if (high < low) {
			return -1;
		}
		
		int mid = (low + high) / 2;

		if (key == a[mid]) {
			return mid;
		} else if (key < a[mid]) {
			return recursive_binary_search(a, low, mid - 1, key);
		} else {
			return recursive_binary_search(a, mid + 1, high, key);
		}

	}

}