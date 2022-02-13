package com.example.linkedlist;



public class MergeTwoSortedList {
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	public static Node mergeSortedList(Node A, Node B) {
		if(A==null) return B;
		if(B==null) return A;
		
		if(A.data<B.data) {
			A.next = mergeSortedList(A.next,B);
			return A;
		}else {
			B.next = mergeSortedList(A,B.next);
			return B;
		}
	}

     public static void main(String[] a) {
    	 
     }
}
