package com.example.tree;



public class LeafCountBTree {
	
	private static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data =data;
			left=null;
			right=null;
		}
	}
	
	public static int getLeafCount(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		
		return getLeafCount(root.left) + getLeafCount(root.right);
	}

	public static void main(String[] args) {
		
		 Node root = new Node(1);
	       root.left = new Node(2);
	       root.right = new Node(3);
	       root.left.left = new Node(4);
	       root.left.right = new Node(5);
	          
	        /* get leaf count of the abve tree */
	        System.out.println("The leaf count of binary tree is : "
	                             +getLeafCount(root));
    

	}

}
