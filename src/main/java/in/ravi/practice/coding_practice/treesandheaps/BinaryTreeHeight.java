/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 13-Jun-2019

 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

public final class BinaryTreeHeight {

	public static int getHeight(Node node) {

		if (node == null) {
			return 0;
		}

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String args[]) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createTree();

		System.out.println("height of binary tree = " + getHeight(binaryTree.root));

	}

}
