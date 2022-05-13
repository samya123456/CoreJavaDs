package com.ds;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val = val;
		}
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new  ArrayList<List<Integer>>();
               if(root==null){
                   return list;
               }
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight =true; 
        q.add(root);
           
       while(!q.isEmpty()){
           int n = q.size();
           LinkedList<Integer> temp = new LinkedList<>();
          
                for(int i=0;i<n;i++){
                   TreeNode current  = q.remove();
                    if(leftToRight){
                        temp.addLast(current.val);
                    }else{
                        temp.addFirst(current.val);
                    }
                    
                      if(current.left!=null){
                               q.add(current.left);
                           }
                            if(current.right!=null){
                               q.add(current.right);
                           }
                   
               
               }
           
           
           leftToRight = !leftToRight;
           list.add( new ArrayList<>(temp));
       }
   
   return list;
   
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
