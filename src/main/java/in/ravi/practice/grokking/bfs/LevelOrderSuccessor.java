package in.ravi.practice.grokking.bfs;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if(null == root)
            return null;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()){
            TreeNode currentNode = treeNodeQueue.poll();
            if(currentNode.left != null)
                treeNodeQueue.offer(currentNode.left);
            if(currentNode.right != null)
                treeNodeQueue.offer(currentNode.right);
            if(currentNode.val == key)
                return treeNodeQueue.peek();
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}

