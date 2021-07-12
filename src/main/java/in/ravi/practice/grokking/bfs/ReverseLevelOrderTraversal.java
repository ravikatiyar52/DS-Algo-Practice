package in.ravi.practice.grokking.bfs;
import java.util.*;

class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if(root == null)
            return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            List<Integer> currentLevelElements = new ArrayList<>();
            int currentLevelNodes = treeNodeQueue.size();
            for(int i = 0 ;i<currentLevelNodes;i++){
                TreeNode currentNode = treeNodeQueue.poll();
                currentLevelElements.add(currentNode.val);
                if(null != currentNode.left)
                    treeNodeQueue.add(currentNode.left);
                if(null != currentNode.right)
                    treeNodeQueue.add(currentNode.right);
            }
            result.add(0,currentLevelElements);
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
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
