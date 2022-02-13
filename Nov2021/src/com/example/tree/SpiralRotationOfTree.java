package com.example.tree;

import java.util.Stack;

public class SpiralRotationOfTree {
	
	static class Node {
		Node left,right;
		int data;
		
		
		Node(int data){
			this.data = data;
			
			left=right=null;
		}
	}
	
	public static void spiralRotation(Node root) {
		
		if(root==null) {
			return;
		}
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.add(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.println(temp.data);
				
				
				if(temp.right!=null) {
					s2.add(temp.right);
				}
				if(temp.left!=null) {
					s2.add(temp.left);
				}
				
			}
			
			
			while(!s2.isEmpty()) {
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
	       
	       spiralRotation(root);
		

	}

}
