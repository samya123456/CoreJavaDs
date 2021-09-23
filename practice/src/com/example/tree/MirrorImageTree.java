package com.example.tree;



public class MirrorImageTree {
	
	static class Node {
	    int data;
	    Node left, right;
	    int hd;
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	
	public static boolean isMirror(Node a1,Node a2) {
		if(a1==null && a2==null) {
			return true;
		}
		
		if(a1!=null && a2!=null 
				&& a1.data ==a2.data) {
			return isMirror(a1.left,a2.right) && isMirror(a1.right,a2.left);
			
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node  root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(2);
       root.left.left = new Node(3);
       root.left.right = new Node(4);
       root.right.left = new Node(4);
       root.right.right = new Node(3);
        boolean output =isMirror(root,root);
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");

	}

}
