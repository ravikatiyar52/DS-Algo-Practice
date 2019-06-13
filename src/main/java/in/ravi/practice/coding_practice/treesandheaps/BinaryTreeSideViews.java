/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 07-Jun-2019
 * 
 * The Tree is:
 *  1 is root
 *  ->R3,L2->L4,R5->L6,R7->R8
 * 
 * 1. The left view contains only the first node from left at every level
 * 2. To print this we traverse the tree recursively (simply by calling node.left and node.right)
 * 3. The printLeftView functions takes the node and the level of that node as the argument.
 * 4. We maintain a global static variable to track the max level so far.
 * 5. In the function we check only if the level > max_level then this node is to be printed. 
 * 6. When we call with the left and right child we have to increment the level. 
 * 
 * 7. We can similarly print the right view but this time in the recursive call we first call (node.right and then node.left)
 */
package in.ravi.practice.coding_practice.treesandheaps;

public class BinaryTreeSideViews {

	public static int max_level = -1;

	private void printLeftView(Node node, int level) {

		if (node == null) {
			return;
		}

		if (level > max_level) {
			System.out.print(node.item + " ");
			max_level = level;
		}

		printLeftView(node.left, level + 1);
		printLeftView(node.right, level + 1);
	}

	private void printRightView(Node node, int level) {

		if (node == null) {
			return;
		}

		if (level > max_level) {
			System.out.print(node.item + " ");
			max_level = level;
		}

		printRightView(node.right, level + 1);
		printRightView(node.left, level + 1);

	}

	public static void main(String args[]) {
		BinaryTreeSideViews binaryTreeLeftView = new BinaryTreeSideViews();
		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.createTree();

		System.out.println("left view");
		binaryTreeLeftView.printLeftView(root, 0);
		System.out.println();
		max_level = -1;
		System.out.println("right view");
		binaryTreeLeftView.printRightView(root, 0);
	}
}
