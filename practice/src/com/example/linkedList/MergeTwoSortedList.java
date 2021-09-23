package com.example.linkedList;

public class MergeTwoSortedList {
	
	public static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	public static Node mergeList(Node A, Node B) {
		if(A==null) return B;
		if(B==null) return A;
		
		if(A.data<B.data) {
			A.next = mergeList(A.next,B);
			return A;
		}else {
			B.next = mergeList(A,B.next);
			return B;
		}
	}

	public static void main(String[] args) {
		Node A = new Node(1);
		A.next = new Node(5);
		A.next.next = new Node(7);
		A.next.next.next = new Node(9);
		
		Node B = new Node(1);
		B.next = new Node(3);
		B.next.next = new Node(4);
		B.next.next.next = new Node(20);
		
		Node result = mergeList(A,B);
		
		while(result!=null) {
			System.out.println(result.data);
			result = result.next;
		}
		
		


	}

}
