package com.practise.Tree;

public class DistanceBetwnTwoNodes {

	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public int findDistance(Node root, int n1, int n2) {
		Node lca = lca(root, n1, n2);
		int d1 = findLevel(lca, n1, 0);
		int d2 = findLevel(lca, n1, 0);
		return d1 + d2;
	}

	private int findLevel(Node lca, int n1, int level) {
		if(lca==null) {
			return -1;
		}
		
		if(lca.data==n1) {
			return level;
		}
		
		int left = findLevel(lca.left,n1,level+1);
		if(left==-1) {
			return findLevel(lca.right ,n1,level+1);
		}else {
			return left;
		}

		
	}

	private Node lca(Node root, int n1, int n2) {
		if (root == null) {
			return root;
		}
			
		if (root.data == n1 || root.data == n2) {
			return root;
		}
			
		Node left = lca(root.left, n1, n2); 
		Node right = lca(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}
		if (left == null && right == null) {
			return null;
		}
		if (left != null) {
			return lca(root.left, n1, n2);
		} else {
			return lca(root.right, n1, n2);
		}

	}

	public static void main(String[] args) {

	}

}
