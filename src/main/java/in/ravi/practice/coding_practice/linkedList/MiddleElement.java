package in.ravi.practice.coding_practice.linkedList;

import java.util.LinkedList;
import java.util.List;

public class MiddleElement {

	public static void main(String args[]) {
		
		List<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		//linkedList.add(40);
		//linkedList.add(50);
		
		printMiddle(linkedList);
	}

	private static void printMiddle(List<Integer> linkedList) {
		
		int size = linkedList.size();
		int fast = 0;
		int slow = 0;
		while(fast < size) {
			slow = slow + 1;
			fast = fast +2;
		}
		System.out.println(linkedList.get(slow-1));
		
	}
}
