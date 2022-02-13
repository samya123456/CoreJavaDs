package com.example.tree;

public class FindClosestElementBST {

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static int findClosest(Node root, int element) {

		int minGap = Integer.MAX_VALUE;
		
		return findClosestUtil(root, element, minGap);

	}

	private static int findClosestUtil(Node root, int element, int minGap) {
		if (root == null) {
			return minGap;
		}

		if (minGap > Math.abs(root.data - element)) {
			minGap = Math.abs(root.data - element);
			

		}
		if (root.data > element) {
			return findClosestUtil(root.left, element, minGap);
		} else {
			return findClosestUtil(root.right, element, minGap);
		}

	}

	public static void main(String[] args) {
		/*Node root = new Node(10);
		root.left = new Node(2);
		root.right =new Node(11);
		root.left.left = new Node(1);
		root.left.right = new Node(5);
		root.left.right.left = new Node(3);
		root.left.right.right = new Node(6);
		root.left.right.left.right = new Node(4);*/
		
		Node root = new Node(8);
		root.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.left = new Node(3);
		root.right = new Node(9);
		root.right.right = new Node(10);
		System.out.println(findClosest(root,9));

	}

}
