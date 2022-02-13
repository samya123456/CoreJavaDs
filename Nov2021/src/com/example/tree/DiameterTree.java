package com.example.tree;



public class DiameterTree {
	
	static class Node {
		Node left,right;
		int data;
		
		
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	
	public static int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		int lDia = diameter(root.left);
		int rDia = diameter(root.right);
		
		return Math.max(lheight+rheight+1, Math.max(lDia, rDia));
		
	}

	private static int height(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+ Math.max(height(root.left),height(root.right));
	}

	public static void main(String[] args) {
		Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       
       System.out.println(diameter(root));

	}

}
