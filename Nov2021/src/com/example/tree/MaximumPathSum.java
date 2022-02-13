package com.example.tree;


public class MaximumPathSum {
	
	 static class Node {
		Node left,right;
		int data;
		
		
		Node(int data){
			this.data = data;
			
			left=right=null;
		}
	}
	
	private static class Res{
		int val;
	}
	
	public  static int findMaxSumUtil(Node root, Res res) {
		if(root==null) {
			return 0;
		}
		
		int l = findMaxSumUtil(root.left,res);
		int r = findMaxSumUtil(root.right,res);
		
		int max_single = Math.max(Math.max(l, r)+root.data, root.data);
		int max_top = Math.max(max_single, l+r+root.data);
		
		res.val = Math.max(res.val, max_top);
		
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
        
        findMaxSumUtil(root,res);
        System.out.println(res.val);
		

	}

}
