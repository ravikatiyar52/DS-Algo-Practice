/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 03-Jun-2019
 * 
 */
package in.ravi.practice.coding_practice.daily_problems;

public class BinraryTree {

	Node root;

	public Node getRoot() {
		return this.root;
	}

	public void createTree() {

		this.root = new Node(1);
		this.root.left = new Node(2);
		this.root.right = new Node(3);
		this.root.left.left = new Node(4);
		this.root.left.right = new Node(5);
		this.root.right.left = new Node(6);
		this.root.right.right = new Node(7);

	}

}
