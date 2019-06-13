/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 26-Feb-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             26-Feb-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

public class BinaryTree {

	Node root;

	public BinaryTree(int key) {
		this.root = new Node(key);
	}

	public BinaryTree() {
		this.root = null;
	}

	public Node createTree() {

		this.root = new Node(1);
		this.root.left = new Node(2);
		this.root.right = new Node(3);
		this.root.left.left = new Node(4);
		this.root.left.right = new Node(5);
		this.root.left.right.left = new Node(6);
		this.root.left.right.right = new Node(7);
		this.root.left.right.right.right = new Node(8);

		return this.root;
	}

	public Node createTree2() {

		this.root = new Node(1);
		this.root.left = new Node(2);
		this.root.right = new Node(3);
		this.root.left.left = new Node(4);
		this.root.left.right = new Node(5);
		this.root.right.left = new Node(6);
		this.root.right.right = new Node(7);
		this.root.right.right.left = new Node(8);
		this.root.right.right.right = new Node(9);

		return this.root;
	}
}
