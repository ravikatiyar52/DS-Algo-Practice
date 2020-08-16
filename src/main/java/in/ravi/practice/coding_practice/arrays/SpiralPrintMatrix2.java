/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 23-Jun-2019
 * 
 *   Most of the work on this question is manipulating indices. 
 *   Make sure that your peer is not using negative or out of bounds indices at any point.
Make sure that all values are copied and that no value is copied more than once.
If your peer is stuck, ask the to look at the illustration provided above and try to discern any patterns from the shape of the spiral.
Any solution that involves changing the matrix is definitely not advised. 
There is no need to do that. If you peer gets there, try to ask them why.
If there is time left, ask your peer to modify the solution to rely only on two indices instead of four. 
This can be achieved by counting the number of copied rows and the number of copied columns from each side. 
The counter will increment after each two rows (top & bottom) or two columns (right & left) are copied.

 * 
 */
package in.ravi.practice.coding_practice.arrays;

public class SpiralPrintMatrix2 {

	public static void main(String args[]) {

		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		int result[] = spiralCopy(a);

		for (int key : result) {
			System.out.print(key + " ");
		}
	}

	static int[] spiralCopy(int[][] inputMatrix) {
		int numRows = inputMatrix.length;
		int numCols = inputMatrix[0].length;

		int topRow = 0;
		int bottomRow = numRows - 1;
		int leftCol = 0;
		int rightCol = numCols - 1;
		int result[] = new int[numRows * numCols];
		int resultCounter = 0;

		while (topRow <= bottomRow && leftCol <= rightCol) {
			// copy the next top row
			for (int i = leftCol; i <= rightCol; i++) {
				result[resultCounter++] = inputMatrix[topRow][i];
			}
			topRow++;

			// copy the next right hand side column
			for (int i = topRow; i <= bottomRow; i++) {
				result[resultCounter++] = inputMatrix[i][rightCol];
			}
			rightCol--;

			// copy the next bottom row
			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					result[resultCounter++] = inputMatrix[bottomRow][i];
				}
				bottomRow--;
			}
			// copy the next left hand side column
			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					result[resultCounter++] = inputMatrix[i][leftCol];
				}
				leftCol++;
			}
		}
		return result;
	}

}
