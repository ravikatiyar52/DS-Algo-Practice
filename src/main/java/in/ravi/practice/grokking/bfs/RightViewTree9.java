package in.ravi.practice.grokking.bfs;

import java.util.*;



class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(null == root)
            return result;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while(!treeNodeQueue.isEmpty()){
            int totalNodesInCurrentLevel = treeNodeQueue.size();
            for(int i=0;i<totalNodesInCurrentLevel;i++){
                TreeNode currentNode = treeNodeQueue.poll();
                //add the last node of every level to the result
                if( i== totalNodesInCurrentLevel-1)
                    result.add(currentNode);
                if( null != currentNode.left)
                    treeNodeQueue.offer(currentNode.left);
                if(null != currentNode.right)
                    treeNodeQueue.offer(currentNode.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}


