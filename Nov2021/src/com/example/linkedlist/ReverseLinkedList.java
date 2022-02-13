package com.example.linkedlist;



public class ReverseLinkedList {
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	
	public static Node reverseLisnkedList(Node head) {
		
		if(head==null) {
			return head;
		}
		Node prev = null;
		Node next = null;
		while(head !=null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
			return prev;
		
		
	}

	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		Node result = reverseLisnkedList(head);
		while(result!=null) {
			System.out.println(result.data);
			result = result.next;
		}
		

	}

}
