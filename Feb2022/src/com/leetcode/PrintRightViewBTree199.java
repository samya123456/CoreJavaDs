package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintRightViewBTree199 {
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val = val;
			left=right=null;
		}
	}
	
	  public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> op = new ArrayList<Integer>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        if(root==null){
	            return op;
	        }
	        
	        queue.add(root);
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i=0;i<size;i++){
	                TreeNode temp =   queue.poll();
	                if(i==size-1){
	                   op.add(temp.val); 
	                }
	                if(temp.left!=null){
	                   queue.add(temp.left) ;
	                }
	                if(temp.right!=null){
	                   queue.add(temp.right) ;
	                }
	            }
	        }
	        return op;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
