package com.tree;

public class CountGoodNodesBinaryTree1448 {
	

	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	 int count =0;
     int max =Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        
        return findGoodNodeUtil(root,max);
        
    }
    
    private int findGoodNodeUtil(TreeNode root,int max){
        if (root ==null){
            return 0;
        }
        if(root.val >= max){
            max = root.val;
            count++;
        }
        
         findGoodNodeUtil(root.left,max);
         findGoodNodeUtil(root.right,max);
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
