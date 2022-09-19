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
	
	public static boolean isBST(TreeNode head,long min,long max) {
		
		if(head == null){
            return true;
        }
        
        if (head.data < max && head.data > min ){
            
           return isBST(head.left, min, head.data) && 
        		   isBST(head.right,head.data, max);
        }
        
        return false;
		
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
 
        if (isBST(root,Long.MIN_VALUE,Long.MAX_VALUE))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    



	}

}
