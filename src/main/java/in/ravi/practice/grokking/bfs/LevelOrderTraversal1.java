/**
 * @author Ravi.Katiyar
 *
 *Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 *
 *Level Order Traversal:  
 [[1],[2,3],[4,5,6,7]]
 *
 *
 * 
 * 
 */
package in.ravi.practice.grokking.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal1 {
	
	public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    List<List<Integer>> result = LevelOrderTraversal1.traverse(root);
	    System.out.println("Level order traversal: " + result);
	  }

	public static List<List<Integer>> traverse(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    
	    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
	    nodeQueue.offer(root);
	    
	    while(!nodeQueue.isEmpty()) {
	    	List<Integer> currentLevelNodeValues = new ArrayList<Integer>();
	    	int currentQueueSize = nodeQueue.size();
	    	for(int thisLevelIterator = 0;thisLevelIterator < currentQueueSize;thisLevelIterator ++) {
	    		TreeNode currentNode = nodeQueue.poll();
	    		currentLevelNodeValues.add(currentNode.val);
	    		if(null != currentNode.left) {
	    			nodeQueue.offer(currentNode.left);
	    		}
	    		if(null != currentNode.right) {
	    			nodeQueue.offer(currentNode.right);
	    		}
	    	}
	    	result.add(currentLevelNodeValues);
	    }
	    
	     return result;
	  }
}


