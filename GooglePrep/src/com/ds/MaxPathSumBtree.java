package com.ds;


public class MaxPathSumBtree {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;

		}
	}

		static class Res {
			int val;
		}
		
		public static int maxSumUtil(Node head ,Res res) {
			if(head ==null) {
				return 0;
			}
			
			int l = maxSumUtil(head.left ,res);
			int r = maxSumUtil(head.right ,res);
			
			int maxSingle = Math.max(Math.max(l,r)+ head.data, head.data);
			int maxSum = Math.max(l+r+head.data, maxSingle);
			res.val = Math.max(res.val, maxSum);
			return maxSingle;
			
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
	        maxSumUtil(root,res);
	        System.out.println("maximum path sum is : " +
	        		res.val);


	}

}
