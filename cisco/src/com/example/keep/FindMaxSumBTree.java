package com.example.keep;

public class FindMaxSumBTree {
	static class Node {
		 
	    int data;
	    Node left, right;
	 
	    public Node(int item) {
	        data = item;
	        left = right = null;
	    }
	}
	
	static class Res{
		int val;
	}
	
	public static int getMaxSum(Node root) {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		 getMaxSumUtil(root,res);
		 return res.val;
	}

	private static int getMaxSumUtil(Node root, Res res) {
		if(root==null) {
			return 0;
		}
		
		int l = getMaxSumUtil(root.left,res);
		int r = getMaxSumUtil(root.right,res);
		
		int max_single = Math.max(Math.max(l, r)+ root.data,root.data);
		int max_top = Math.max(max_single, l+r+root.data);
		res.val = Math.max(max_top, res.val);
		
		
		
		return max_single;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(10);
       root.left = new Node(2);
       root.right = new Node(10);
       root.left.left = new Node(20);
       root.left.right = new Node(1);
       root.right.right = new Node(-25);
       root.right.right.left = new Node(3);
       root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
        		getMaxSum(root));

	}

}
