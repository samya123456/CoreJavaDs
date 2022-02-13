package com.example.linkedlist;



public class RotateLinkedList {
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	public static Node rotate(Node head ,int k) {
		if(k==0 || head==null) {
			return head;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next=head;
		while(k>0) {
			current = current.next;
			k--;
		}
		
	
		     Node op  = current.next;
			 current.next =null;
			 return op;
		
		
		
		
	}

	public static void main(String[] args) {
		// 10->20->30->40->50->60 and k is 4
		//50->60->10->20->30->40
		
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		
		Node result = rotate(head,3);
		while(result!=null) {
			System.out.println(result.data);
			result = result.next;
		}

	}

}
