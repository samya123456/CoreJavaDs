package com.example.keep;



public class CheckForBST {
	
	static class Node {
	    int data;
	    Node left, right;
	 
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}

	static boolean checkBST(Node head) {
		return checkBSTUtil(head,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	static boolean checkBSTUtil(Node head , int min ,int max) {
		if(head==null) {
			return true;
		}
		
		if(head.data<min || head.data>max) {
			return false;
		}
		
		return checkBSTUtil(head.left, min, head.data-1) &&
				checkBSTUtil(head.left, head.data +1, max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
