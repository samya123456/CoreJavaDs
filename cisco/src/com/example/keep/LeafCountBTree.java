package com.example.keep;

public class LeafCountBTree {
	
	 static class Node
	{
	    int data;
	    Node left, right;
	  
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}

	 
	 static int getLeafCount(Node root) {
		 if(root==null) {
			 return 0;
		 }
		 
		 if(root.left==null && root.right==null) {
			 return 1;
		 }
		 
		 return getLeafCount(root.left) + getLeafCount(root.right);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
