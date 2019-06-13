/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 12-Jun-2019
 * 
 * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeTopView {

	public static Map<Integer, Node> nodeMap = new TreeMap<Integer, Node>();

	public static void pushToNodeMap(Node node) {

		if (node == null) {
			return;
		}

		class QueueNode {
			Node treeNode;
			int hd;

			public QueueNode(Node node, int hd) {
				super();
				this.treeNode = node;
				this.hd = hd;
			}

		}

		Queue<QueueNode> queue = new LinkedList<QueueNode>();

		QueueNode queueNode = new QueueNode(node, 0);
		queue.add(queueNode);

		while (!queue.isEmpty()) {

			QueueNode head = queue.poll();

			Node presentInMap = nodeMap.get(Integer.valueOf(head.hd));
			if (presentInMap == null) {
				nodeMap.put(Integer.valueOf(head.hd), head.treeNode);
			}

			if (head.treeNode.left != null) {
				QueueNode leftQueueNode = new QueueNode(head.treeNode.left, head.hd - 1);
				queue.add(leftQueueNode);
			}

			if (head.treeNode.right != null) {
				QueueNode rightQueueNode = new QueueNode(head.treeNode.right, head.hd + 1);
				queue.add(rightQueueNode);
			}

		}

	}

	public static void main(String args[]) {

		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.createTree2();
		
		pushToNodeMap(root);

		for (Integer key : nodeMap.keySet()) {
			System.out.print(nodeMap.get(key).item + "");

		}

	}

}
