package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class AllNodesDistanceKBinaryTree863 {
	
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
	
	 public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
	        
	        Map<TreeNode,TreeNode> parent_track = new HashMap<>();
	        markParent(root,parent_track);
	        Map<TreeNode,Boolean> visited = new HashMap<>();
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(target);
	        visited.put(target,true);
	        int curr_level =0;
	        
	        while(!q.isEmpty()){
	            int size = q.size();
	            
	            if(curr_level == k){
	                break;
	            }
	            curr_level++;
	            
	            for(int i =0;i<size;i++){
	                TreeNode temp = q.remove();
	                
	                if(temp.left!=null && visited.get(temp.left) ==null){
	                    visited.put(temp.left,true);
	                    q.add(temp.left);
	                }
	                 if(temp.right!=null && visited.get(temp.right) ==null){
	                    visited.put(temp.right,true);
	                    q.add(temp.right);
	                }
	                 if(parent_track.get(temp)!=null && visited.get(parent_track.get(temp))==null){
	                    visited.put(parent_track.get(temp),true);
	                    q.add(parent_track.get(temp));
	                }
	                
	            }
	        }
	        
	        List<Integer> op = new ArrayList<>();
	        
	        while(!q.isEmpty()){
	            TreeNode temp = q.remove();
	            op.add(temp.val);
	        }
	        
	        return op;
	        
	    }
	    
	 private void markParent(TreeNode root,  Map<TreeNode,TreeNode> parent_track){
	         
	         Queue<TreeNode> q = new LinkedList<>();
	         q.add(root);
	         
	         while(!q.isEmpty()){
	             TreeNode temp = q.remove();
	             if(temp.left!=null){
	                 parent_track.put(temp.left,temp);
	                 q.add(temp.left);
	             }
	             if(temp.right!=null){
	                 parent_track.put(temp.right,temp);
	                 q.add(temp.right);
	             }
	         }
	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
