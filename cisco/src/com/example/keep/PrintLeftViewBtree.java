package com.example.keep;

public class PrintLeftViewBtree {
	static int MAX_HD =0;
	static class Node {
	    int data;
	    Node left, right;
	 
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	public void printLeftView(Node head, int hd) {
		if(head==null) {
			return;
		}
		
		if(MAX_HD<hd) {
			System.out.println(head.data);
			MAX_HD =hd;
		}
		printLeftView(head.left,hd+1);
		printLeftView(head.left,hd+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
