package in.ravi.practice.coding_practice.arrays;

/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown
 * to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise
 * a way to find an element in the rotated array in O(log n) time
 *
 * 
 * Solution : we need to find pivot element (this will be the first element
 * where the number next to it will not be greater than this number) and divide
 * the array into two sub arrays from the pivot point. we can now perform binary
 * search on one of these two sorted sub arrays. Also note that we can find
 * pivot using binary search technique only in O(log n) time
 * 
 * @author Ravi.Katiyar
 *
 */
public class SearchInSortedAndRotatedArray {

	
	public static void main(String args[]) {
		
		int a[] = {3,4,5,1,2};
		int key = 4;
		int index_found = -1;
		
		int pivot = findPivot(a, 0, a.length-1);
		
		if(pivot == -1) {
			index_found = BinarySearch.recursive_binary_search(a, 0, a.length -1, key);
		}
		
		if(key >= a[0]) {
			index_found = BinarySearch.recursive_binary_search(a, 0, pivot, key);
		}else {
			index_found = BinarySearch.recursive_binary_search(a, pivot+1, a.length -1, key);
		}
		
		System.out.println("element found at index " + index_found);
	}
	
	public static int findPivot(int a[], int low, int high) {

		if (high < low) {
			return -1;
		}

		if (high == low) {
			return low;
		}
		int mid = (low + high) / 2;

		if (mid < high && (a[mid] > a[mid + 1])) {
			return mid;
		}

		if (low < mid && (a[mid]) < a[mid - 1]) {
			return mid - 1;
		}

		if (a[low] > a[mid]) {
			return findPivot(a, low, mid);
		}

		return findPivot(a, mid + 1, high);
	}
}
