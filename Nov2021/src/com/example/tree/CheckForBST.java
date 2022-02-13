package com.example.tree;



public class CheckForBST {
	
	static class Node {
		Node left,right;
		int data;
		
		Node(int data){
			this.data = data;
		}
	}
	static boolean checkForBSTUtil(Node root, Integer min, Integer max) {
		
		if(root ==null) {
			return true;
		}
		
		if(root.data <min && root.data>max) {
			return false;
		}
		
		return checkForBSTUtil(root.left,min,root.data-1) 
				&& checkForBSTUtil(root.right,root.data+1,max) ;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        
        System.out.println(checkForBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

	}

}
