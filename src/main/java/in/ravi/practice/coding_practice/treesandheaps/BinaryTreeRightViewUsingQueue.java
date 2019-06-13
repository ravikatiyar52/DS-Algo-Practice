/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 07-Jun-2019
 * 
 * The Tree is:
 *  1 is root
 * 1 ->R3,L2->L4,R5->L6,R7->R8
 * 
 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRightViewUsingQueue {

	static Node defaultNode = new Node(-999);

	private void printRightView(Node root, Queue<Node> queue) {

		while (!queue.isEmpty()) {
			Node head = queue.poll();
			Node itemNextToHead = queue.peek();

			if (itemNextToHead != null) {
				if (itemNextToHead.item == -999) {
					System.out.print(head.item + " ");
					queue.poll();
					addChildNodes(queue, head);
					queue.add(defaultNode);
				} else {
					addChildNodes(queue, head);
				}
			}

		}

	}

	private void addChildNodes(Queue<Node> queue, Node head) {
		if (head.left != null) {
			queue.add(head.left);
		}
		if (head.right != null) {
			queue.add(head.right);
		}
	}

	public static void main(String args[]) {
		BinaryTreeRightViewUsingQueue binaryTreeLeftView = new BinaryTreeRightViewUsingQueue();
		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.createTree();

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(defaultNode);
		binaryTreeLeftView.printRightView(root, queue);
	}
}
