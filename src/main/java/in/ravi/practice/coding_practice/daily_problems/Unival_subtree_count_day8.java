
package in.ravi.practice.coding_practice.daily_problems;
/*
 * 
 * @author Ravi.Katiyar
 *
 *         A unival tree (which stands for “universal value”) is a tree where
 *         all nodes have the same value.
 * 
 *         Given the root to a binary tree, count the number of unival subtrees.
 * 
 *         A unival tree or a universal subtree is a tree where all nodes of
 *         same value
 *         -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 * 
 */

// Refer this link for explanation
// https://www.youtube.com/watch?v=7HgsS8bRvjo&t=306s
public class Unival_subtree_count_day8 {

	public static boolean is_unival(Node root) {

		//an empty tree is unival
		if (root == null) {
			return true;
		}

		if ((root.left != null && root.left.item != root.item) || (root.left != null && root.left.item != root.item)) {
			return false;
		}

		if ((is_unival(root.left)) && (is_unival(root.right))) {
			return true;
		}

		return false;
	}

	public static int count_unival(Node root) {

		if (root == null) {
			return 0;
		}

		int total = count_unival(root.left) + count_unival(root.right);

		if (is_unival(root)) {
			total = total + 1;
		}

		return total;
	}
	
	public static void main(String args[]) {
		
		Node root = new Node(5);
		root.left = new Node(5);
		root.right = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(5);
		root.right.left = new Node(5);
		root.right.right = new Node(5);
		
		System.out.println(count_unival(root));
	}

}
