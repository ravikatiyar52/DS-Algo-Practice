/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 07-Jan-2020
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             07-Jan-2020         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.arrays;

public class QuickSort {
	
	
	public static void main(String args[]) {
		
		int a[] = {5,2,1,6,3};
		
		performQuickSort(a, 0, a.length -1);
		
		for(int e : a) {
			System.out.print(e + " ");
		}
		
	}
	
	
	public static void performQuickSort(int a[],int start,int end) {
		
		if(start < end) {
			
			int pivot = partition(a, start, end);
			
			performQuickSort(a, start, pivot -1);
			performQuickSort(a, pivot + 1, end);
		}
		
	}

	public static int partition(int a[],int start,int end) {

		int pivotIndex = end;
		int i = -1;

		for (int j = 0; j <= end; j++) {

			if (a[j] < a[pivotIndex]) {
				i = i + 1;
				swap(a, i, j);
			}
		}
		
		swap(a, i+1, pivotIndex);

		return i+1;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}
