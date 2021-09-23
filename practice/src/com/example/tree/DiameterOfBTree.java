package com.example.tree;



public class DiameterOfBTree {
	
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
	
	private static int diameter(Node root) {
		if(root==null) {
			return 0;
			
		}
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		int lDiameter = diameter(root.left);
		int rDiameter = diameter(root.right);
		
		return Math.max(rHeight+lHeight+1,Math.max(lDiameter,rDiameter));
	}
	
	private static int height(Node root) {
		if(root==null) {
			return 0;
		}
		
		return 1+ Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
 
        // Function Call
        System.out.println(
            "The diameter of given binary tree is : "
            + diameter(root));

	}

}
