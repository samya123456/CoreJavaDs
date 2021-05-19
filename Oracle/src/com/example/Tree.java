package com.example;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;

public class Tree {
	
	ArrayList<Integer> ar = new ArrayList<Integer>();
    
    int max_level =0;
	
	static class Node{
		int data;
		Node left;
		Node right;
		int hd =Integer.MAX_VALUE;
		public Node(int data) {
			this.data =data;
			left=null;
			right=null;
		}
	}
	
	public ArrayList<Integer> leftView(Node root)
	    {
	      
		leftViewUtil(root,1);
		return ar;
	      
	    }
	public void leftViewUtil(Node root, int level) {
		if (root==null) {
			return;
		}
		
		if(max_level<level) {
			ar.add(root.data);
			max_level=level;
		}
		
		leftViewUtil(root.left,level+1);
		leftViewUtil(root.right,level+1);
	}
	 boolean isBST(Node root)
     {
		 if(root==null) {
			 return true;
		 }
		 
		if(root.left!=null && root.right!=null) {
			if(root.data>root.left.data && root.data<root.right.data) {
				return true;
			}
		}
		
		 return isBST(root.left) && isBST(root.right);
        
     }
	 
	 boolean isBSTUtil(Node root,int min,int max) {
		 if(root==null) {
			 return true;
		 }
		 if(root.data<min || root.data>max) {
			 return false;
		 }
		 
		 return isBSTUtil(root.left,min , root.data-1) &&
			    isBSTUtil(root.right,root.data-1 , max);
		 
	 }
	 
	 
	 
	 public void bottomView(Node root){
		 
		 Queue<Node> queue =new LinkedList<Node>();
		 Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		 if(root==null) {
			 return ;
		 }
		 
		 int hd =0;
		 root.hd=hd;
		 queue.add(root);
		 //treeMap.put(hd,root.data);
		 
		 while(!queue.isEmpty()) {
			 Node temp = queue.remove();
			 
			 hd =temp.hd;
			 treeMap.put(hd, temp.data);
			 
			 if(temp.left!=null) {
				 temp.left.hd =hd -1; 
				 queue.add(temp.left);
			 }
			 
			 if(temp.right!=null) {
				 temp.right.hd =hd+1;
				 queue.add(temp.right);
			 }
		 }
		 
		 Set<Map.Entry<Integer,Integer>> st = treeMap.entrySet();
		 for(Map.Entry<Integer,Integer> entry:st) {
			 System.out.println(entry.getValue());
		 }
		 
		 
	 }
	int countLeaves(Node head) {
		if (head==null) {
			return 0;
		}
		if(head.left==null && head.right==null) {
			return 1;
		}
		
		return countLeaves(head.left) +countLeaves(head.right);
	}
	
	int diameterTree(Node root) {
		if(root==null) {
			return 0;
		}
		int lHeight= heigth(root.left);
		int rHeight = heigth(root.right);
		
		int ldiameter =diameterTree(root.left);
		int rdiameter =diameterTree(root.right);
		
		return Math.max(lHeight+rHeight+1,Math.max(ldiameter,rdiameter));
	}
	
	int heigth(Node root) {
		if (root==null) {
			return 0;
		}
		
		return 1+Math.max(heigth(root.left), heigth(root.right));
	}

	boolean IdenticalTree(Node root1 , Node root2) {
		if(root1==null && root2==null) {
			return true;
		}
		
		if(root1!=null && root2!=null) {
			return (root1.data ==root2.data)&&
					(IdenticalTree(root1.left,root2.left))&&
					IdenticalTree(root1.left,root2.left);
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Node root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 
        
        new Tree().bottomView(root);

	}

}
