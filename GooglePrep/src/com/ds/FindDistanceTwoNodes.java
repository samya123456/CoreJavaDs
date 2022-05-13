package com.ds;

public class FindDistanceTwoNodes {
	
	static class Node {
		Node left;
		Node right;
		int data;
		
		Node(int data ){
			this.data =data;
		}
	}
		
		public static int findDistance(Node head,int n1,int n2) {
			if(head==null) {
				return 0;
			}
			
			Node lca = findLCA(head,n1,n2);
			int d1 = findlevel(lca,n1,0);	
			int d2 = findlevel(lca,n2,0);
			
			return d1+d2;
			
		}

		private static int findlevel(Node lca, int n1, int level) {
			if(lca==null) {
				return -1;
			}
			if(lca.data ==n1) {
				return level;
			}
			
			Integer left = findlevel(lca.left,n1,level+1);
			if(left !=-1) {
				return left;
			}else {
				return findlevel(lca.right,n1,level+1);
			}
		}

		private static Node findLCA(Node head, int n1, int n2) {
			if(head ==null) {
				return head;
			}
			
			if(head.data ==n1 || head.data==n2) {
				return head;
			}
			
			Node left = findLCA(head.left ,n1,n2);
			Node right = findLCA(head.right ,n1,n2);
			
			if(left!=null && right!=null) {
				return head;
			}
			
			if(left==null && right==null) {
				return null;
			}
			
			if(left!= null) {
				return findLCA(head.left ,n1,n2);
			}else {
				return findLCA(head.right ,n1,n2);
			}
			
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
	    System.out.println("Dist(4, 5) = " +
                findDistance(root, 4, 5));
System.out.println("Dist(4, 6) = " +
                findDistance(root, 4, 6));
System.out.println("Dist(3, 4) = " +
                findDistance(root, 3, 4));
System.out.println("Dist(2, 4) = " +
                findDistance(root, 2, 4));
System.out.println("Dist(8, 5) = " +
                findDistance(root, 8, 5));
	}

}
