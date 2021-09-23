package com.example.tree;

public class LeftViewBTree {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
		  	this.data =data;
		  	left=null;
		  	right=null;
		}
	}
	
	
	static int max_level=0;
	
	public static void printLeftView(Node root,int level) {
		if (root==null) {
			return;
		}
		if(max_level<level) {
			System.out.println(root.data);
			max_level=level;
		}
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
		
	}

	public static void main(String[] args) {
		
		Node node = new Node(12);
		node.left= new Node(10);
		node.right = new Node(30);
		node.right.left = new Node(25);
		node.right.right = new Node(40);
		printLeftView(node,1);


	}

}
