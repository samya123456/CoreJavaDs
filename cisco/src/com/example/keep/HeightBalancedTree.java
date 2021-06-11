package com.example.keep;



public class HeightBalancedTree {
	
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}
	
	public boolean isBalanced(Node root) {
		if(root==null) {
			return true;
		}
		
		int lHeight = height(root.left);
		int rHieght = height(root.right);
		
		if(Math.abs(rHieght-lHeight)<=1
				&& isBalanced(root.left)
				&& isBalanced(root.right)) {
			return true;
		}
		
		return false;
	}

	private int height(Node root) {
		if(root==null) {
			return 0;	
		}
		
		return 1+ Math.max(height(root.left), height(root.right));
		
	}

	public static void main(String[] args) {
		

	}

}
