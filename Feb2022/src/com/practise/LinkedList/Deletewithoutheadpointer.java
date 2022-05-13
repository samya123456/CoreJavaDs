package com.practise.LinkedList;



public class Deletewithoutheadpointer {
	
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	
	public void deleteNode(Node nodeToBeDeleted) {
		Node next =nodeToBeDeleted.next;
		nodeToBeDeleted.data = next.data;
		nodeToBeDeleted.next = next.next;
		
	}

	public static void main(String[] args) {
		

	}

}
