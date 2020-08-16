/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 23-Jun-2019
 * 
 * 
 */
package in.ravi.practice.coding_practice.arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class SpiralPrintMatrix {

	Set<MatrixElement> visitedElementSet = new LinkedHashSet<SpiralPrintMatrix.MatrixElement>();

	int matrixRow;
	int matixColumn;

	enum TraverseType {
		ROW, COLUMN
	}

	public class MatrixElement {
		int row;
		int column;

		public MatrixElement(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + column;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MatrixElement other = (MatrixElement) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (column != other.column)
				return false;
			if (row != other.row)
				return false;
			return true;
		}

		private SpiralPrintMatrix getOuterType() {
			return SpiralPrintMatrix.this;
		}

	}

	public MatrixElement traverse(boolean rowTraversal, int row, int column) {

		MatrixElement lastVisitedElement = null;
		if (rowTraversal) {
			// traverse row from left to right
			for (int columnNumber = row; columnNumber < column; columnNumber++) {
				MatrixElement matrixElement = new MatrixElement(row, columnNumber);
				if (!visitedElementSet.contains(matrixElement)) {
					lastVisitedElement = matrixElement;
					visitedElementSet.add(matrixElement);
				}
			}
		}

		return lastVisitedElement;
	}

}
