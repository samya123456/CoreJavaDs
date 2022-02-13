package com.example.tree;

public class BoundaryTraversalBTree {

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void printLeftBoundaryTree(Node root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			System.out.println(root.data);
			printLeftBoundaryTree(root.left);
		} else if (root.right != null) {
			System.out.println(root.data);
			printLeftBoundaryTree(root.right);
		}

	}

	public static void printRightBoundaryTree(Node root) {
		if (root == null) {
			return;
		}
		if (root.right != null) {
			printRightBoundaryTree(root.right);
			System.out.println(root.data);

		} else if (root.left != null) {
			printRightBoundaryTree(root.left);
			System.out.println(root.data);

		}

	}

	public static void printLeaves(Node root) {

		if (root == null) {
			return;
		}
		printLeaves(root.left);

		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		printLeaves(root.right);
	}

	public static void printboundary(Node root) {
		if (root == null) {
			return;
		}

		System.out.println(root.data);
		printLeftBoundaryTree(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printLeftBoundaryTree(root.right);
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

		printboundary(root);

	}

}
