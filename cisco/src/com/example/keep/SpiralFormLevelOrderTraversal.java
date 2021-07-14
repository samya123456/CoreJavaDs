package com.example.keep;



public class SpiralFormLevelOrderTraversal {
	
	
	
	static class Node
	{
	    int data;
	    Node left, right;

	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	public static void spiralFormLevelOrderTraversal(Node head){
		
		int i =1;
		int j = height(head);
		
		boolean ltr =false;
		while(i<=j) {
			printGivenLevel(head,i,ltr);
			ltr=!ltr;
			i++;
			
		}
 		
	}

	private static int height(Node head) {
		if(head==null) {
			return 0;
		}
		
		int il= height(head.left);
		int ir= height(head.right);
		return 1+Math.max(il, ir);
	}

	private static void printGivenLevel(Node head, int level, boolean ltr) {
		if(head==null) {
			return;
		}
		
		if(level==1) {
			System.out.println(head.data);
		}else if(level>1) {
			if(ltr==true) {
				printGivenLevel(head.left,level-1,ltr);
				printGivenLevel(head.right,level-1,ltr);
				
			}else {
				printGivenLevel(head.right,level-1,ltr);
				printGivenLevel(head.left,level-1,ltr);
			}
		}
		
	}

	public static void main(String[] args) {
		
		
        Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(7);
       root.left.right = new Node(6);
       root.right.left = new Node(5);
       root.right.right = new Node(4);
        System.out.println("Spiral order traversal of Binary Tree is ");
        spiralFormLevelOrderTraversal(root);
		

	}

}
