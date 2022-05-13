package com.example.tree;

public class DistanceBetweenTwoNodes {

	private static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	private static Node LCA(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		if (root.value == n1 || root.value == n2) {
			return root;
		}

		Node left = LCA(root.left, n1, n2);
		Node right = LCA(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}

		if (left == null && right == null) {
			return null;
		}
		if (left != null) {
			return LCA(root.left, n1, n2);
		} else {
			return LCA(root.right, n1, n2);
		}
	}
	
	private static int findLevel(Node root,int data,int level) {
		if(root==null) {
			return -1;
		}
		
		if(root.value==data) {
			return level;
		}
		int left =findLevel(root.left, data,level+1);
		if(left ==-1) {
			return findLevel(root.right, data,level+1);
		}
		return left;
	}
	
	
	public static int findDistance(Node root, int n1,int n2) {
		
		Node lca = LCA(root,n1,n2);
		int d1 = findLevel(lca,n1,0);
		int d2 = findLevel(lca,n2,0);
		
		return d1+d2;
	}
	
	
	

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                           + findDistance(root, 4, 5));

	}

}
