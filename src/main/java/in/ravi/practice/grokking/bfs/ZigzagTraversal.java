package in.ravi.practice.grokking.bfs;

import java.util.*;

class ZigzagTraversal {


    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(null == root)
            return result;

        boolean traverseFromLeft = true;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()){
            int nodesInCurrentLevel = treeNodeQueue.size();
            List<Integer> currentLevelElements = new ArrayList<>();
            for(int i =0;i<nodesInCurrentLevel;i++){
                TreeNode currentNode = treeNodeQueue.poll();
                if(traverseFromLeft)
                    currentLevelElements.add(currentNode.val);
                else
                    currentLevelElements.add(0,currentNode.val);

                if( null !=currentNode.left)
                    treeNodeQueue.add(currentNode.left);
                if(null != currentNode.right)
                    treeNodeQueue.add(currentNode.right);
            }
            result.add(currentLevelElements);
            traverseFromLeft = !traverseFromLeft;
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
