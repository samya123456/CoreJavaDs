package com.example.keep;

public class MaxPathSumTree {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}
	
	static class Res{
		int val;
	}
	
	static int maxPathSum(Node root ,Res res) {
		if(root==null) {
			return 0;
		}
		
		if(root.left== null && root.right==null) {
			return root.data;
		}
		
		int ls = maxPathSum(root.left,res);
		int rs = maxPathSum(root.right,res);
		
		if(root.left!=null && root.right!=null) {
			res.val = Math.max(res.val, (rs+ls+root.data));
			return Math.max(ls, rs)+ root.data;
		}
		
		return (root.left==null) ? rs + root.data :ls + root.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(0);
        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);
        Res res = new Res();
        maxPathSum(root,res);
        System.out.println("Max pathSum of the given binary tree is "
                + res.val);

	}

}
