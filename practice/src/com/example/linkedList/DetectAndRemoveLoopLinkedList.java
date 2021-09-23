package com.example.linkedList;

public class DetectAndRemoveLoopLinkedList {
	
	
	public static class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	public static Node detectAndRemoveLoop(Node head) {
		
		if(head ==null || head.next==null) {
			return head;
		}
		
		Node slow = head;
		Node  fast = head;
		
		slow = slow.next;
		fast = fast.next.next;
		
		while(fast!=null && fast.next!=null) {
			if(slow==fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow==fast) {
			slow =head;
			if(slow!=fast) {
				while(slow.next!=fast.next) {
					slow = slow.next;
					fast = fast.next;
				}
				fast.next =null;
				
			}else {
				while(fast.next !=slow) {
					fast = fast.next;
				}
				fast.next =null;
			}
		}
		
		return head;
		
	}
	static void printList(Node node)
	    {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }

	public static void main(String[] args) {
		
		    Node head = new Node(50);
	        head.next = new Node(20);
	        head.next.next = new Node(15);
	        head.next.next.next = new Node(4);
	        head.next.next.next.next = new Node(10);
	  
	        // Creating a loop for testing
	        head.next.next.next.next.next = head.next.next;
	        detectAndRemoveLoop(head);
	        System.out.println("Linked List after removing loop : ");
	        printList(head);
		

	}

}
