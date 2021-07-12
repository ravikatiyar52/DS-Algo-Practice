package in.ravi.practice.grokking.inPlaceReversalLinkedList;

public class ReverseEveryAlternateKElements {

    public static ListNode reverse(ListNode head, int k) {

        ListNode currentSublistHeadBeforeRev = head;
        ListNode prevSublistHeadbeforeRev = null;
        ListNode current = currentSublistHeadBeforeRev;
        while (current != null && currentSublistHeadBeforeRev != null) {
            current = currentSublistHeadBeforeRev;
            ListNode prev = null;
            ListNode next = null;
            int nodeReversed = 0;
            //reverse K nodes
            while (nodeReversed != k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                nodeReversed++;
            }
            //connect the reversed sublist to the next node of the list
            currentSublistHeadBeforeRev.next = next;
            if (prevSublistHeadbeforeRev == null) // first sublist is reversed so update the head
                head = prev;
            else
                prevSublistHeadbeforeRev.next = prev;
            if (current != null) {
                prevSublistHeadbeforeRev = current;
                currentSublistHeadBeforeRev = current.next;
                //skip k nodes

                for (int i = 0; i < k - 1; i++) {
                    prevSublistHeadbeforeRev = prevSublistHeadbeforeRev.next;
                    currentSublistHeadBeforeRev = currentSublistHeadBeforeRev.next;
                }
            }
        }
        return head;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        //head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        //head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        //head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
       // head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);
       // head.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(14);

        ListNode result = ReverseEveryAlternateKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
