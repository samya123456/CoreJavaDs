package com.ds;



public class BoundaryTravarsalBTree {
	
	static class Node{
		Node left;
		Node right;
		
		int data ;
		
		Node(int data){
			left =right =null;
			this.data = data;
		}
		
	}
	
	public static void printBoundary(Node root) {
		if (root==null) {
			return;
		}
		System.out.println(root.data);
		printLeftBoundary(root.left);
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		printRightNodes(root.right);
	}

	private static void printLeftBoundary(Node root) {
		if(root==null) {
			return;
		}
		
		if(root.left!=null) {
			System.out.println(root.data);
			printLeftBoundary(root.left);
		}else if(root.right!=null) {
			System.out.println(root.data);
			printLeftBoundary(root.right);
		}
		
	}

	private static void printLeafNodes(Node root) {
		
		if(root==null) {
			return;
		}
		
		if(root.left!=null) {
			printLeafNodes(root.left);
		}
		
		if(root.left==null && root.right==null) {
			System.out.println(root.data);
		}
		
		if(root.right!=null) {
			printLeafNodes(root.right);
		}
		
		
	}

	private static void printRightNodes(Node root) {
		if(root==null) {
			return;
		}
		if(root.right!=null) {
			System.out.println(root.data);
			printRightNodes(root.right);
		}else if(root.left!=null) {
			System.out.println(root.data);
			printRightNodes(root.left);
		}
		
	}

	public static void main(String[] args) {
		
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		printBoundary(root);

	}

}
