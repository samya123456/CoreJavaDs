package com.example.linkedlist;



public class RemoveLoopLinkedList {
	
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	
	public static Node detectNRemoveLoop(Node head) {
		if(head==null) {
			return head;
		}
		
		Node fast = head;
		Node slow = head;
		
		slow = slow.next;
		fast = fast.next.next;
		while(fast !=null && fast.next!=null) {
			if(fast==slow) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow==fast) {
			slow = head;
			if(slow!=fast) {
				while(slow.next != fast.next) {
					slow =slow.next;
					fast =fast.next;
				}
				
				fast.next =null;
			}else {
				while(fast.next !=slow) {
					fast =fast.next;
				}
				fast.next =null;
				
			}
			
		}
		
		return head;
		
	}

	public static void main(String[] args) {
		
		Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
 
        
        head.next.next.next.next.next = head.next.next;
		Node result = detectNRemoveLoop(head);
		
		while(result!=null) {
			System.out.println(result.data);
			result = result.next;
		}

	}

}
