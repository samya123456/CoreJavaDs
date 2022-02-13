package com.example.tree;

public class LeftViewBTree {
	
	static class Node {
		Node left,right;
		int data;
		
		Node(int data){
			this.data = data;
		}
	}
	static int max_level=0;
	static void printLeftView(Node root,int level) {
		if(root==null) {
			return;
		}
		
		if(max_level<level) {
			System.out.println(root.data);
			max_level = level;
		}
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
		
	}

	public static void main(String[] args) {
			Node root = new Node(10);
			root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(7);
	        root.left.right = new Node(8);
	        root.right.right = new Node(15);
	        root.right.left = new Node(12);
	        root.right.right.left = new Node(14);
	 
		       printLeftView(root,1);

	}

}
