package com.example.linkedlist;

public class FindMiddleLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
		
		
	}
	
	
	public static int getMiddle(Node head) {
		  Node fast = head;
		  Node slow = head;
		  
		  while(fast!=null && fast.next !=null) {
			  fast = fast.next.next;
			  slow = slow.next;
		  }
		  return slow.data;
	}

	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(5);
		System.out.println(getMiddle(head));

	}

}
