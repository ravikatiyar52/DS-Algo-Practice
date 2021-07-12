package in.ravi.practice.grokking.inPlaceReversalLinkedList;


class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        int currentNodeIndex = 1;
        ListNode currentSublistHeadBeforeRev = head;
        ListNode prevSublistHeadbeforeRev = null;
        int linkedListLength = getLength(head);

        while (currentNodeIndex + k <= linkedListLength) {
            ListNode current = currentSublistHeadBeforeRev;
            ListNode prev = null;
            ListNode next = null;

            while (currentNodeIndex % (k+1) != 0) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                currentNodeIndex++;
            }
            if (prevSublistHeadbeforeRev != null) {
                prevSublistHeadbeforeRev.next = prev;
            } else {
                //first K node reversed
                head = prev;
            }
            prevSublistHeadbeforeRev = currentSublistHeadBeforeRev;
            currentSublistHeadBeforeRev = next;
            currentNodeIndex++;
        }
        ListNode current = currentSublistHeadBeforeRev;
        ListNode prev = null;
        ListNode next;
        while (current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
        }
        prevSublistHeadbeforeRev.next = prev;
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

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
