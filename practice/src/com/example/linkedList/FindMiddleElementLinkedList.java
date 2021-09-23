package com.example.linkedList;



public class FindMiddleElementLinkedList {
	
	
	public static class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next =null;
		}
	}
	
	
	public static int findMiddleElement(Node head) {
		Node fast =head;
		Node slow = head;
		
		while(fast!=null && fast.next!=null) {
			fast= fast.next.next;
			slow= slow.next;
		}
		return slow.data;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		n1.next.next.next.next = new Node(5);
        System.out.println(findMiddleElement(n1));

	}

}
