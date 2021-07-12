package in.ravi.practice.grokking.slowAndFastPointers;




class RearrangeList {

    public static void reorder(ListNode head) {

        //find the middle of the linked List
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow should now point to the middle of the list
        //Now Reverse the second half of the list pointed by Slow
        ListNode head2 = reverseList(slow);
        ListNode head1 = head;
        //now rearrange the pointers to achieve the required order

        while(head2.next !=null){
            ListNode temp = head1.next;
            head1.next = head2;
            head1 = temp;
            temp = head2.next;
            head2.next = head1;
            head2 = temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
      // head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;

        while(current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(current != null)
                next = current.next;
        }
        return  prev;
    }
}
