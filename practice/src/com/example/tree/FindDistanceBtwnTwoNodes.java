package com.example.tree;

public class FindDistanceBtwnTwoNodes {
	
	
	public static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data =data;
			left=null;
			right=null;
		}
	}
	
	private static Node LCA(Node root,int n1,int n2) {
		if(root==null) {
			return root;
		}
		if(root.data==n1 || root.data==n2) {
			return root;
		}
		Node left = LCA(root.left,n1,n2);
		Node right = LCA(root.right,n1,n2);
		
		if(left!=null && right!=null) {
			return root;
		}
		if(left==null && right==null) {
			return null;
		}
		if(left!=null) {
			return LCA(root.left,n1,n2);
		}else {
			return LCA(root.right,n1,n2);
		}
	}
	
	private static int findLevel(Node root,int a, int level) {
		if (root==null) {
			return -1;
		}
		if(root.data==a) {
			return level;
		}
		
		int left =findLevel(root.left,a,level+1);
		if(left==-1) {
			return findLevel(root.right,a,level+1);
		}
		return left;
	}
	
	private static int findDistance(Node root, int a ,int b) {
		Node LCA = LCA(root,a,b);
		int d1 = findLevel(LCA,a,0);
		int d2 = findLevel(LCA,b,0);
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
                              
        System.out.println("Dist(4, 6) = "
                             + findDistance(root, 4, 6));
                              
        System.out.println("Dist(3, 4) = "
                             + findDistance(root, 3, 4));
                              
        System.out.println("Dist(2, 4) = "
                             + findDistance(root, 2, 4));
                              
        System.out.println("Dist(8, 5) = "
                             + findDistance(root, 8, 5));
 
		

	}

}
