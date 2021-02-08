/**
 * @author Ravi.Katiyar
 *
 *Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */
package in.ravi.practice.grokking.slowAndFastPointers;

class ListNode {
	  int value = 0;
	  ListNode next;

	  ListNode(int value) {
	    this.value = value;
	  }
	}

	class LinkedListCycleStart {

	  public static ListNode findCycleStart(ListNode head) {
	   ListNode pointer1 = head;
	   ListNode pointer2 = head;
	   int cycleLength = getCycleLength(head);
	   for(int i=0;i<cycleLength;i++) {
		   pointer2=pointer2.next;
	   }
	   
	   while(pointer1 != pointer2) {
		   pointer1=pointer1.next;
		   pointer2=pointer2.next;
	   }
		  
	    return pointer1;
	  }
	  
	  public static int getCycleLength(ListNode head) {
		  int length = 1;
		  
		  ListNode slow = head;
		  ListNode fast = head;
		  
		  slow=slow.next;
		  fast=fast.next.next;
		  
		  while(slow !=fast) {
			  slow=slow.next;
			  fast=fast.next.next;
		  }
		  
		  ListNode temp = slow.next;
		 
		  
		  while(temp !=slow) {
			  temp=temp.next;
			  length ++;
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

	    head.next.next.next.next.next.next = head.next.next;
	    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

	    head.next.next.next.next.next.next = head.next.next.next;
	    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

	    head.next.next.next.next.next.next = head;
	    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
	  }
	}


