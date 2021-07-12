package in.ravi.practice.grokking.bfs;

import java.util.*;

class TreeNodeWithNext {
    int val;
    TreeNodeWithNext left;
    TreeNodeWithNext right;
    TreeNodeWithNext next;

    TreeNodeWithNext(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNodeWithNext nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeWithNext current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(TreeNodeWithNext root) {
        if(null == root)
            return;
        Queue<TreeNodeWithNext> treeNodeWithNextQueue = new LinkedList<>();
        treeNodeWithNextQueue.offer(root);
        while(!treeNodeWithNextQueue.isEmpty()){
            int totalNodesInCurrentLevel = treeNodeWithNextQueue.size();
            for(int i=0;i<totalNodesInCurrentLevel-1;i++){
                TreeNodeWithNext current = treeNodeWithNextQueue.poll();
                TreeNodeWithNext nodeNextToCurrent = treeNodeWithNextQueue.peek();
                if(null != nodeNextToCurrent)
                    current.next = nodeNextToCurrent;
                pushChildNodesToQueue(treeNodeWithNextQueue, current);
            }
            //the last node in this level
            pushChildNodesToQueue(treeNodeWithNextQueue,treeNodeWithNextQueue.poll());
        }
    }

    private static void pushChildNodesToQueue(Queue<TreeNodeWithNext> treeNodeWithNextQueue, TreeNodeWithNext current) {
        if(null != current.left)
            treeNodeWithNextQueue.offer(current.left);
        if(null != current.right)
            treeNodeWithNextQueue.offer(current.right);
    }

    public static void main(String[] args) {
        TreeNodeWithNext root = new TreeNodeWithNext(12);
        root.left = new TreeNodeWithNext(7);
        root.right = new TreeNodeWithNext(1);
        root.left.left = new TreeNodeWithNext(9);
        root.right.left = new TreeNodeWithNext(10);
        root.right.right = new TreeNodeWithNext(5);
        root.left.left.left = new TreeNodeWithNext(6);
        root.left.left.right = new TreeNodeWithNext(7);
        root.right.left.left = new TreeNodeWithNext(14);
        root.right.left.right = new TreeNodeWithNext(15);

        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}

