package in.ravi.practice.grokking.inPlaceReversalLinkedList;

/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
 */
import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode beforeSubListHead = null;
        ListNode subListHead = head;
        int i =0;
        while( i < p -1){
            beforeSubListHead = subListHead;
            subListHead=subListHead.next;
            i++;
        }

        ListNode current = subListHead;
        ListNode prev = null;
        ListNode next = null;

        int k =0;
        while(k <= q-p){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k++;
        }
        if(beforeSubListHead == null) // p == 1
            head = prev;
        else
            beforeSubListHead.next = prev;


        subListHead.next = next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
