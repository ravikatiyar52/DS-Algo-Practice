package in.ravi.practice.grokking.bfs;

import java.util.*;


class ConnectAllSiblings {
    public static void connect(TreeNodeWithNext root) {
        if(null == root)
            return;
        Queue<TreeNodeWithNext> treeNodeWithNextQueue = new LinkedList<>();
        TreeNodeWithNext prev = null;
        treeNodeWithNextQueue.offer(root);
        while (! treeNodeWithNextQueue.isEmpty()) {
            TreeNodeWithNext current = treeNodeWithNextQueue.poll();
            if (null != prev)
                prev.next = current;
            prev = current;
            pushChildNodesToQueue(treeNodeWithNextQueue,current);
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
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNodeWithNext current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
