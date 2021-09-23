package com.example.tree;


public class MaximumPathSumBTree {
	
	private static class Node{
		int data;
		Node right;
		Node left;
		Node(int data){
			this.data =data;
			left=null;
			right=null;
		}
	}
	
	private static class Res{
		int val;
	}
	
	private static int findMaxUtil(Node root,Res res) {
		
		if(root==null) {
			return 0;
		}
		
		int l = findMaxUtil(root.left,res);
		int r = findMaxUtil(root.right,res);
		
		int max_single = Math.max(Math.max(l, r)+ root.data, root.data); 
		int max_top = Math.max(max_single, l+r+root.data);
		
		res.val = Math.max(max_top, res.val);
		return max_single;
	}
	
	

	public static void main(String[] args) {
		
		
	        Node root = new Node(10);
	        root.left = new Node(2);
	        root.right = new Node(10);
	        root.left.left = new Node(20);
	        root.left.right = new Node(1);
	        root.right.right = new Node(-25);
	        root.right.right.left = new Node(3);
	        root.right.right.right = new Node(4);
	        
	        Res res = new Res();
	        res.val = Integer.MIN_VALUE;
	        findMaxUtil(root,res);
	        System.out.println("maximum path sum is : " +
	        		res.val);



	}

}
