package in.ravi.practice.grokking.inPlaceReversalLinkedList;

/**
 * Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.
 */


class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        ListNode prev= null;
        ListNode current = head ;
        ListNode next= null;

        while (current!= null) {
            next= current.next;
            current.next= prev;
            prev= current;
            current= next;
        }
        head= prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
