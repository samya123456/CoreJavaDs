package com.example.linkedList;

public class ReverseLinkedList {
	
	public static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next=null;
		}
	}
	
	
	public static Node reverseLinkedList(Node head) {
		if(head==null) {
			return null;
		}
		
		Node nextNode=null;
		Node prev=null;
		
		while(head!=null) {
			nextNode = head.next;
			head.next = prev;
			prev = head;
			head = nextNode;
		}
		
		return prev;
	}
	
	

	public static void main(String[] args) {
		
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		
		Node head = reverseLinkedList(n1);
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}


	}

}
