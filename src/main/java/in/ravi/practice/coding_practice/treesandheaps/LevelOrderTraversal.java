/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 06-Jun-2019
 
 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String args[]) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createTree();

		printLevelOrder(binaryTree.root);

	}

	private static void printLevelOrder(Node root) {

		Queue<Node> queue = new LinkedList<Node>();
		Node changeLineNode = new Node(-999);

		queue.add(root);
		queue.add(changeLineNode);

		while (!queue.isEmpty()) {
			Node head = queue.poll();

			if (head.item == -999) {
				System.out.println();
				Node nextItem = queue.peek();
				if (nextItem != null) {
					queue.add(changeLineNode);
				}
			} else {
				System.out.print(head.item + " ");
				if (head.left != null) {
					queue.add(head.left);
				}
				if (head.right != null) {
					queue.add(head.right);
				}
			}

		}

	}

}
