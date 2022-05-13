package com.practise.LinkedList;


public class RotateLinkedListInGroup {
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	public static Node rotate(Node head ,int k) {
		
		int count =0;
		
		Node current = head;
		Node prev =null;
		Node next =null;
		while(count<k &&current!=null) {
		    next = current.next;
		    current.next =prev;
		    prev =current;
		    current = next;
		    count++;
		}
		
		if(next!=null) {
			head.next = rotate(next,k);
		}
		
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
