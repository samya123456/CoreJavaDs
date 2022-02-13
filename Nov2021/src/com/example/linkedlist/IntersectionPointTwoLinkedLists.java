package com.example.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPointTwoLinkedLists {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	public static Node intersectionPoint(Node A,Node B) {
		Set<Node> st = new HashSet<Node>();
		
		while(A!=null) {
			st.add(A);
			A= A.next;
		}
		
		while(B!=null) {
			if(st.contains(B)) {
				return B;
			}
			B= B.next;
		}
		 
		return null;
		
	}

	public static void main(String[] args) {
		

	}

}
