package com.ds;

import java.util.HashSet;
import java.util.Set;

public class LinkedListExampl {

	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public static int findMiddleElement(Node head) {
		if (head == null) {
			return -1;
		}
		if (head.next == null) {
			return -1;
		}

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (slow != null) {
			return slow.val;
		} else {
			return -1;
		}
	}

	public static Node reverseLinkedList(Node head) {
		Node next = null;
		Node prev = null;

		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}
	
	public static Node reverseLinkedListWithGivenSize(Node head,int k) {
		
		if(head==null || k==0) {
			return head;
		}
		
		int count =0;
		
		Node next =null;
		Node prev=null;
		while(count <k && head!=null) {
			next = head.next;
			head.next = prev;
			prev =head;
			head =next;
		}
		
		if(next!=null) {
			head.next = reverseLinkedListWithGivenSize(next,k);
		}
		return prev;
	}
	
	
	public static Node rotateLinkedList(Node head ,int k) {
		if (k==0) {
			return head;
		}
		
		Node temp = head;
		
		while(temp.next!=null) {
			temp =temp.next;
		}
		
		temp.next = head;
		temp =head;
		
		for(int i=0;i<k-1;i++) {
			temp =temp.next;
		}
		head =temp.next;
		temp.next = null;
		
		return head;
	}
	
	public static void detectNRemoveLoopLinkedList(Node head) {
		Node slow =head;
		Node fast = head;
		
		while(slow!=null && fast!=null && fast.next!=null) {
			slow =slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				break;
			}
		}
		if(slow==fast) {
			slow=head;
			if(slow!=fast) {
				while(fast.next!=slow.next) {
					fast =fast.next;
					slow = slow.next;
				}
				
				
				
			}else {
				while(fast.next !=slow) {
					fast =fast.next;
				}
				
				fast.next=null;
			}
		}
	}
	
	public static boolean detectAndRemoveLoop(Node head) {
		Set<Node> set =new HashSet<Node>();
		
		Node prev =null;
		while(head!=null) {
			if(!set.contains(head)) {
				set.add(head);
				prev =head;
				head =head.next;
			}else {
				prev.next =null;
				return true;
			}
		}
		
		return false;
	}
	
	public Node mergeTwoSortedList(Node A,Node B) {
		if(A==null) return B;
		if(B==null) return A;
		
		if(A.val<B.val) {
			A.next = mergeTwoSortedList(A.next,B);
			return A;
		}else {
			B.next = mergeTwoSortedList(A,B.next);
			return B;
		}
		
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);

		Node temp =rotateLinkedList(head,4);
		
		while(temp!=null) {
			System.out.println(temp.val);
			temp=temp.next;
		}

	}

}
