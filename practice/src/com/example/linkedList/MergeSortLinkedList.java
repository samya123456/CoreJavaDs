package com.example.linkedList;

public class MergeSortLinkedList {
	
	private static class Node{
		int data ;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	private static Node getMiddle(Node head) {
		if (head==null) {
			return head;
		}
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
		
	}
	
	
	
	private static Node sortedMerge(Node A, Node B) {
		if(A==null) return B;
		if(B==null) return A;
		
		if(A.data<B.data) {
			A.next = sortedMerge(A.next,B);
			return A;
		}
		else {
			B.next = sortedMerge(A,B.next);
			return B;
		}
	}
	
	
	public static Node mergeSort(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node middle = getMiddle(head);
		Node middleToNext = middle.next;
		middle.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(middleToNext);
		Node sortedList  = sortedMerge(left,right);
		return sortedList;
	}

	public static void main(String[] args) {

		 Node head = new Node(1);
		 head.next = new Node(2);
		 head.next.next = new Node(8);
		 head.next.next.next = new Node(4);
		 
		Node sortedList =  mergeSort(head);
		
		while(sortedList!=null){
			System.out.println(sortedList.data);
			sortedList = sortedList.next;
		}
		

	}

}
