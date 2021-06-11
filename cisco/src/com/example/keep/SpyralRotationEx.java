package com.example.keep;

public class SpyralRotationEx {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void  leftToRight(Node root,int level) {
		if(root==null) {
			return;
		}
		if(level==1) {
			System.out.println(root.data);
		}else if (level>1){
			leftToRight(root.left,level-1);
			leftToRight(root.right,level-1);
		}
		
	}
	
	public static void  rightToleft(Node root,int level) {
		if(root==null) {
			return;
		}
		if(level==1) {
			System.out.println(root.data);
		}else if (level>1){
			rightToleft(root.right,level-1);
			rightToleft(root.left,level-1);
		}
		
	}
	
	public static int length(Node root) {
		if(root==null)
		{
			return 0;
		}
		int lh = length(root.left);
		int rh = length(root.right);
		
		return 1+ Math.max(lh, rh);
	}
	
	static void antiClockWiseSpiral(Node root) {
		int i=1;
		int j = length(root);
		int flag =0;
		while(i<=j) {
			if(flag==0) {
				rightToleft(root,i);
				i++;
				flag=1;
			}else {
				leftToRight(root,j);
				j--;
				flag=0;
			}
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
	   
	    antiClockWiseSpiral(root);

	}

}
