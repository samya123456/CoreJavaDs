package com.example.tree;



public class CheckBST {
	
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data){
			this.data = data;
			left=null;
			right=null;
		}
		
		
	}
	
	public static boolean isBST(TreeNode head,int min,int max) {
		
		if(head ==null) {
			return true;
		}
		
		if(head.data<min && head.data>max) {
			return false;
		}
		
		return isBST(head.left,min,head.data-1) && 
			   isBST(head.right,head.data+1,max);
		
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
 
        if (isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    



	}

}
