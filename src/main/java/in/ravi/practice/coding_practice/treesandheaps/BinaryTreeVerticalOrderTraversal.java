/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 11-Jun-2019
 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Ravi.Katiyar
 *
 *         Creation Date : 11-Jun-2019
 * 
 *         We need to check the Horizontal Distances from root for all nodes. If
 *         two nodes have the same Horizontal Distance (HD), then they are on
 *         same vertical line. The idea of HD is simple. HD for root is 0, a
 *         right edge (edge connecting to right subtree) is considered as +1
 *         horizontal distance and a left edge is considered as -1 horizontal
 *         distance. For example, in the above tree, HD for Node 4 is at -2, HD
 *         for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2. We can
 *         do preorder traversal of the given Binary Tree. While traversing the
 *         tree, we can recursively calculate HDs. We initially pass the
 *         horizontal distance as 0 for root. For left subtree, we pass the
 *         Horizontal Distance as Horizontal distance of root minus 1. For right
 *         subtree, we pass the Horizontal Distance as Horizontal Distance of
 *         root plus 1. For every HD value, we maintain a list of nodes in a
 *         hash map. Whenever we see a node in traversal, we go to the hash map
 *         entry and add the node to the hash map using HD as a key in map.
 */

public class BinaryTreeVerticalOrderTraversal {

	public static Map<Integer, List<Node>> nodeMap = new TreeMap<Integer, List<Node>>();

	/**
	 * 
	 * @param root
	 */
	public static void pushToNodeMap(Node node, int level) {

		if (node == null) {
			return;
		}

		List<Node> nodeListInMap = nodeMap.get(Integer.valueOf(level));

		if (nodeListInMap != null) {
			nodeListInMap.add(node);
		} else {
			List<Node> nodeList = new ArrayList<Node>();
			nodeList.add(node);
			nodeMap.put(level, nodeList);
		}

		pushToNodeMap(node.left, level - 1);
		pushToNodeMap(node.right, level + 1);

	}

	public static void main(String args[]) {

		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.createTree2();

		pushToNodeMap(root, 0);

		for (Integer key : nodeMap.keySet()) {
			for (Node node : nodeMap.get(key)) {
				System.out.print(node.item + " ");
			}
			System.out.println();
		}

	}
}
