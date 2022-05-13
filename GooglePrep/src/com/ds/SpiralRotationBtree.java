package com.ds;

import java.util.Stack;

public class SpiralRotationBtree {
	
	 static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data =data;
			left=null;
			right=null;
		}
	}
	
	public static void printSpiral(Node head) {
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.add(head);
		
		while(!s1.empty() || !s2.empty()) {
			
			while(!s1.empty()) {
				Node temp = s1.pop();
				if(temp.right!=null) {
					s2.add(temp.right);
				}
				System.out.println(temp.data);
				if(temp.left!=null) {
					s2.add(temp.left);
				}
				
				
			}
			
			while(!s2.empty()) {
				Node temp = s2.pop();
				System.out.println(temp.data);
				if(temp.left!=null) {
					s1.add(temp.left);
				}
				
				if(temp.right!=null) {
					s1.add(temp.right);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		
		   Node root = new Node(1);
	       root.left = new Node(2);
	       root.right = new Node(3);
	       root.left.left = new Node(7);
	       root.left.right = new Node(6);
	       root.right.left = new Node(5);
	       root.right.right = new Node(4);
	       
	       printSpiral(root);

	}

}
