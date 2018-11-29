/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 27-Nov-2018
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             27-Nov-2018         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.arrays;

/**
 * 
 * @author Ravi.Katiyar
 *
 *         Creation Date : 27-Nov-2018
 * 
 *         Description : Type description here Program Specs Referred : -
 * 
 *
 *         -------------------------------------------------------------------------------------------------------------------------------------------------------
 *         Revision: Version Last Revision Date Name Function/Module affected
 *         Modification Date
 * 
 *         0.0.1 0.0.0.1 27-Nov-2018 Ravi.Katiyar --
 * 
 *         -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 *         Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
 *         elements 
 *         Given arr[1,2,3,4,5,6,7] 
 *         Rotation of this array by 2 will make array 
 *          arr[3,4,5,6,7,1,2]
 */
public class LeftRotateArray {

	public static void main(String args[]) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		leftRotateUsingTempArray(a, 4);

		for (int element : a) {
			System.out.print(element + " ");
		}
	}

	public static void leftRotateUsingTempArray(int a[], int d) {

		if (d > 0) {
			int temp[] = new int[d];
			int i = 0;
			for (; i < d; i++) {
				temp[i] = a[i];
			}

			for (; i < a.length; i++) {
				a[i - d] = a[i];
			}

			for (int t = 0, j = a.length - d; j < a.length; j++, t++) {
				a[j] = temp[t];
			}

		}
	}
}
