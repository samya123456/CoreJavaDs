package com.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;



public class MaximumWidthBinaryTree {
	
	public static class TreeNode {
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
	
	
	 public static int widthOfBinaryTree(TreeNode root) {
	        
	        if(root ==null){
	            return 0;
	        }
	        
	        Queue<Map<TreeNode,Integer>> q = new LinkedList<>();
	        Map<TreeNode,Integer> rootMap = new HashMap<>();
	        rootMap.put(root,0);
	        int max =0;
	        q.add(rootMap);
	        while(!q.isEmpty()){
	            
	            int size =  q.size();
	            Map<TreeNode,Integer> first = q.peek();
	            Map<TreeNode,Integer> curr =null;
	            for(int i=0;i<size;i++){
	                curr = q.remove();
	                Map.Entry<TreeNode,Integer> entry = curr.entrySet().iterator().next(); 
	                TreeNode currNode = entry.getKey();
	                int index = entry.getValue();
	                
	                if(currNode.left!=null){
	                    Map<TreeNode,Integer> leftMap = new HashMap<>(); 
	                    leftMap.put(currNode.left,2*index);
	                    q.add(leftMap);
	                }
	                 if(currNode.right!=null){
	                    Map<TreeNode,Integer> rightMap = new HashMap<>(); 
	                    rightMap.put(currNode.right,2*index+1);
	                    q.add(rightMap);
	                }
	                
	            }
	            
	            max  =  Math.max(max, curr.entrySet().iterator().next().getValue() - 
	                            first.entrySet().iterator().next().getValue() +1);
	        }
	        
	        return max;
	        
	    }

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left =  new TreeNode(3);
		root.right =  new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right =  new TreeNode(9);
		
		System.out.println(widthOfBinaryTree(root));
		

	}

}
