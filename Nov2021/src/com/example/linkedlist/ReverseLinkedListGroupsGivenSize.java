package com.example.linkedlist;


public class ReverseLinkedListGroupsGivenSize {
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	
	public static Node reverseLinkedList(Node head, int k) {
		Node current = head;
		Node prev = null;
		Node next = null;
		int count =0;
		if(head==null || k==0) {
			return head;
		}
		
		while(count<k && current!=null) {
			 next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;
			 count++;
		}
		
		if(next!=null) {
			head.next = reverseLinkedList(next,k);
		}
		return prev;
		
	}

	public static void main(String[] args) {
		

	}

}
