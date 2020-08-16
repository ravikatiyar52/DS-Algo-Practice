/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 14-Jan-2020
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             14-Jan-2020         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.treesandheaps;

public class BasicTreeTraversal {
	
	public static void preOrderTraversal(Node node) {
		
		if(node == null) {
			return;
		}
		
		System.out.print(node.item + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
public static void inOrderTraversal(Node node) {
		
		if(node == null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.print(node.item + " ");
		inOrderTraversal(node.right);
	}

public static void postOrderTraversal(Node node) {
	
	if(node == null) {
		return;
	}
	
	
	postOrderTraversal(node.left);
	postOrderTraversal(node.right);
	System.out.print(node.item + " ");
	
}

static int max = Integer.MIN_VALUE;
public static void getMax(Node node) {
	
	if(node == null) {
		return ;
	}
	
	getMax(node.left);
	if(node.item > max) {
		max = node.item;
	}
	getMax(node.right);
	
	
}

public static void main(String args[]) {
	
	BinaryTree binaryTree = new BinaryTree();
	Node root = binaryTree.createTree();
	
	//postOrderTraversal(root);
	getMax(root);
	System.out.println("Max value in tree " + max);
}

}


