/**
 * @author Ravi.Katiyar
 * 
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished.
 The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList
 * 
 * 
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
Output: false
 * 
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true
 */
package in.ravi.practice.grokking.slowAndFastPointers;

public class PalindromicLinkedList {

	
	  public static void main(String[] args) {
		    ListNode head = new ListNode(2);
		    head.next = new ListNode(4);
		    head.next.next = new ListNode(6);
		    head.next.next.next = new ListNode(4);
		    head.next.next.next.next = new ListNode(2);
		    
		    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

		    head.next.next.next.next.next = new ListNode(2);
		    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
		  }
	
	public static boolean isPalindrome(ListNode head) {

		boolean palindromeResult = true;


		System.out.println("before checking for palindrome ");
		printLinkedList(head);
		
		// find the middle node started
		ListNode middle = null;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next != null) {
			middle = slow.next;
			fast = fast.next;
		} else {
			middle = slow;
		}
		
		// find the middle node completed

		// reverse the linkedList between middle and end
		ListNode headSecondHalfAfterReverse = reverseLinkedListBetweenTwoNodes(middle, fast);

		// if list is a palindrome all elements in first of all list must be equal to
		// second half of the reversed list and in same order
		ListNode headTemp = head;
		ListNode headSecondHalfAfterReverseTemp = headSecondHalfAfterReverse;

		while (headTemp != headSecondHalfAfterReverseTemp) {
			if (headTemp.value != headSecondHalfAfterReverseTemp.value) {
				palindromeResult = false;
				break;
			}
			headTemp = headTemp.next;
			headSecondHalfAfterReverseTemp = headSecondHalfAfterReverseTemp.next;
		}

		// reverse the second half of the linked list again so that it is again back as
		// original
		reverseLinkedListBetweenTwoNodes(headSecondHalfAfterReverse, middle);
		
		System.out.println("after checking for palindrome ");
		printLinkedList(head);

		return palindromeResult;
	}

	public static ListNode reverseLinkedList(ListNode head) {

		ListNode prev = null;
		ListNode next = null;
		ListNode current = head;

		while (next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;

		return head;

	}

	public static ListNode reverseLinkedListBetweenTwoNodes(ListNode start, ListNode end) {

		ListNode prev = null;
		ListNode next = null;
		ListNode current = start;

		while (prev != end) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		start = prev;

		return start;

	}
	
	public static void printLinkedList(ListNode head) {
		ListNode temp = head;
		StringBuilder output = new StringBuilder("");
		while(temp !=null) {
			output.append(temp.value);
			if(temp.next != null) {
				output.append(" --> ");
			}
			temp = temp.next;
		}
		System.out.println(output);
	}
}
