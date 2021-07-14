package com.example.keep;


public class FindDistanceBetweenTwoNodesOfBinaryTree {
	private static class Node {
        int value;
        Node left;
        Node right;
 
        public Node(int value) {
            this.value = value;
        }
    }
	
	
	public static int findDistanceBetweenTwoNodesOfBinaryTree(Node root , int n1,int n2) {
		Node lca = LCA(root, n1,n2);
		
		int d1 = findDistance(lca,n1,0);
		int d2 = findDistance(lca,n2,0);
		
		return d1 + d2;
	}
	

	private static int findDistance(Node lca, int n1, int level) {
		
		if(lca==null) {
			return -1;
		}
		if(lca.value==n1) {
			return level;
		}
		int left = findDistance(lca.left,n1,level+1);
		if(left==-1) {
			return findDistance(lca.right,n1,level+1);
		}
		
		return left;
	}


	private static Node LCA(Node root, int n1, int n2) {
		
		if(root==null) {
			return null;
		}
		
		if(root.value==n1 || root.value==n2) {
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


	public static void main(String[] args) {
	    //https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/ sol-2
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                             + findDistanceBetweenTwoNodesOfBinaryTree(root, 4, 5));
                              
        System.out.println("Dist(4, 6) = "
                             + findDistanceBetweenTwoNodesOfBinaryTree(root, 4, 6));
                              
        System.out.println("Dist(3, 4) = "
                             + findDistanceBetweenTwoNodesOfBinaryTree(root, 3, 4));
                              
        System.out.println("Dist(2, 4) = "
                             + findDistanceBetweenTwoNodesOfBinaryTree(root, 2, 4));
                              
        System.out.println("Dist(8, 5) = "
                             + findDistanceBetweenTwoNodesOfBinaryTree	(root, 8, 5));

	}

}
