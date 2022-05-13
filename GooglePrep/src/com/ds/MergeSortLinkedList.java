package com.ds;

public class MergeSortLinkedList {
	
	static class Node{
		Node next;
		int data;
		Node(int data){
			this.data =data;
		}
	}
	
	
	public static Node mergeSort(Node head) {
		if(head ==null || head.next==null) {
			return head;
		}
		
		Node middle = getMiddle(head);
		Node nexttoMiddle = middle.next;
		middle.next =null;
		Node left =mergeSort(head);
		Node right=mergeSort(nexttoMiddle);
		Node list= merge(left,right);
		return list;
	}

	private static Node merge(Node A, Node B) {
		if(A==null) return B;
		if(B==null) return A;
		
		if(A.data<B.data) {
			A.next = merge(A.next,B);
			return A;
		}else {
			B.next = merge(A,B.next);
			return B;		
		}
		
		
		
		
	}

	private static Node getMiddle(Node current) {
		if(current==null) {
			return current;
		}
		
		Node fast = current;
		Node slow = current;
		
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			
		}
		return slow;
	}

	public static void main(String[] args) {
		Node head = new Node(7);
		head.next = new Node(10);
		head.next.next = new Node(5);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(3);
		Node list = mergeSort(head);
		
		while(list!=null) {
			System.out.println(list.data);
			list =list.next;
		}
		

	}

}
