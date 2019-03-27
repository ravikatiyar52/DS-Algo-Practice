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
}
