package com.practise.Tree;

public class CheckForBST {

	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public boolean isBSTUtil(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return isBSTUtil(root.left, min, root.data - 1) && 
				isBSTUtil(root.right, root.data+1,max );

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
