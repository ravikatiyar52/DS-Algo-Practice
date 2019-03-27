/**
 * @author Ravi.Katiyar
 *
 *Construct Tree from given Inorder and Preorder traversals
Let us consider the below traversals:

Inorder sequence: D B E A F C
Preorder sequence: A B D E C F
 * 
 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

public class ConstructTreeFromTraversal {

	static int preOrderIndexCounter = 0;

	public Node buildTree(int[] inorder, int[] preorder, int start, int end) {

		if (start > end) {
			return null;
		}

		Node node = new Node(preorder[preOrderIndexCounter++]);

		if (start == end) {
			return node;
		}

		int inOrderIndex = searchIndex(inorder, node.item);

		node.left = buildTree(inorder, preorder, start, inOrderIndex - 1);
		node.right = buildTree(inorder, preorder, inOrderIndex + 1, end);

		return node;

	}

	public int searchIndex(int[] inorder, int searchKey) {

		int index = -1;
		int counter = 0;
		for (int c : inorder) {
			if (c == searchKey) {
				index = counter;
				break;
			}
			counter++;
		}

		return index;
	}

	//these printInorder and printPreorder are just for verification of constructed tree
	public void printInorder(Node root) {

		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.item + " ");
		printInorder(root.right);
	}

	public void printPreorder(Node root) {

		if (root == null) {
			return;
		}
		System.out.print(root.item + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	public static void main(String args[]) {
		ConstructTreeFromTraversal constructTreeFromTraversal = new ConstructTreeFromTraversal();

		int[] inorder = { 4, 2, 5, 1, 6, 3 };
		int[] preorder = { 1, 2, 4, 5, 3, 6 };

		Node root = constructTreeFromTraversal.buildTree(inorder, preorder, 0, preorder.length - 1);
		System.out.println("inorder");
		constructTreeFromTraversal.printInorder(root);
		System.out.println();
		System.out.println("preorder");
		constructTreeFromTraversal.printPreorder(root);

	}

}
