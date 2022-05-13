package com.practise.Tree;



public class PopulatingNextRightPointers {
	
	class Node {
		int data;
		Node left, right,next;

		public Node(int item) {
			data = item;
			left = right = next= null;
		}
	}
	
	public Node populateNextRight(Node root) {
		
		
		Node current =   root;
		while(current.left!=null) {
			Node temp = current;
			while(current!=null) {
				current.left.next = current.right;
				current.right.next = current.next ==null? null :  current.next.left;
				current = current.next;
			}
			temp = temp.left;
		}
		
		return root;
	}

	public static void main(String[] args) {
		

	}

}
