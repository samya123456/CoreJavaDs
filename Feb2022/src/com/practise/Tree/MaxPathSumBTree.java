package com.practise.Tree;



public class MaxPathSumBTree {
	
	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}
	
	class Res{
		int val;
	}
	
	public int maxPathSumUtil(Node root,Res res) {
		if(root==null) return 0;
		
		int l = maxPathSumUtil(root.left,res);
		int r = maxPathSumUtil(root.right,res);
		
		int max_single = Math.max(Math.max(l, r)+root.data,root.data);
		int max_top = Math.max(max_single, l+r+root.data);
		res.val = Math.max(max_top, res.val);
		return max_single;
	}

	public static void main(String[] args) {
		

	}

}
