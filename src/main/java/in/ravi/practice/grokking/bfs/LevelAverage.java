package in.ravi.practice.grokking.bfs;
import java.util.*;

class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(null == root)
            return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            double totalNodesInCurrentLevel = treeNodeQueue.size();
            double currentLevelSum = 0;
            for(int i=0;i<totalNodesInCurrentLevel;i++){
                TreeNode currentNode = treeNodeQueue.poll();
                currentLevelSum += currentNode.val;
                if(null != currentNode.left)
                    treeNodeQueue.offer(currentNode.left);
                if(null != currentNode.right)
                    treeNodeQueue.offer(currentNode.right);
            }
            double currentLevelAvg = currentLevelSum/totalNodesInCurrentLevel;
            result.add(currentLevelAvg);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}

