package com.ravi.practice.coding_practice.linkedList;

public class CustomLinkedList {

	public CustomLinkedList() {
		//CustomLinkedList newNode = new CustomLinkedList();
		this.next = null;
		//this.next = null;
	}

	CustomLinkedList head;
	int data;
	CustomLinkedList next;

	public void add(int data) {

		if (this.head == null) {
			CustomLinkedList newNode = new CustomLinkedList();
			this.data = data;
			this.next = null;
			this.head = newNode;

		} else {
			CustomLinkedList temp = this.head;

			while (temp != null) {
				temp = temp.next;
			}
			CustomLinkedList newNode = new CustomLinkedList();
			newNode.data = data;
			newNode.next = null;
		}

	}

	public void print() {

		CustomLinkedList temp = this.head;

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

}
