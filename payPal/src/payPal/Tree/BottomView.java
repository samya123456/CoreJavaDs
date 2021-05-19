package payPal.Tree;

import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class BottomView {
	
	
	public static void printBottomView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();
		if(root==null)
			return;
		int hd =0;
		root.hd =hd;
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			 hd =temp.hd;
			 mp.put(hd, temp.data);
			 
			 if(temp.left!=null) {
				 temp.left.hd = hd-1;
				 q.add(temp.left);
			 }
			 
			 if(temp.right!=null) {
				 temp.right.hd = hd+1;
				 q.add(temp.right);
			 }
		}
		
		Set<Map.Entry<Integer, Integer>> st = mp.entrySet();
		
		for(Map.Entry<Integer, Integer> entry: st) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 TreeNode root = new TreeNode(20);
	        root.left = new TreeNode(8);
	        root.right = new TreeNode(22);
	        root.left.left = new TreeNode(5);
	        root.left.right = new TreeNode(3);
	        root.right.left = new TreeNode(4);
	        root.right.right = new TreeNode(25);
	        root.left.right.left = new TreeNode(10);
	        root.left.right.right = new TreeNode(14);
	        
	        printBottomView(root);

	}

}
