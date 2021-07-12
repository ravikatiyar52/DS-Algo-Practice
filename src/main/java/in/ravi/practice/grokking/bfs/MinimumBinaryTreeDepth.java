package in.ravi.practice.grokking.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the minimum depth of a binary tree.
 * The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
 */
class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
       int minimunHeight = 0;
       if(null == root)
           return minimunHeight;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty() ){
            minimunHeight++;
            int totalNodesInCurrentLevel = treeNodeQueue.size();
            for(int i=0;i<totalNodesInCurrentLevel;i++){
                TreeNode currentNode = treeNodeQueue.poll();
                if(currentNode.left == null && currentNode.right == null)
                    return minimunHeight;
                if(null != currentNode.left)
                    treeNodeQueue.offer(currentNode.left);
                if(null != currentNode.right)
                    treeNodeQueue.offer(currentNode.right);
            }
        }
        return minimunHeight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
