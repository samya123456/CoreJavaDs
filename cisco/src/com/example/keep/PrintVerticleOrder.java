package com.example.keep;

import java.util.*;

public class PrintVerticleOrder {
static Map<Integer,ArrayList<Integer>> mp = new TreeMap <Integer,ArrayList<Integer>> ();
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
   public static void printVerticleOrder(Node head) {
	  
	   printVerticleOrderUtil(head,1,mp);
   }
	private static void printVerticleOrderUtil(Node head, int hd, Map<Integer, ArrayList<Integer>> mp) {
	if(head==null) {
		return;
	}
	if(mp.containsKey(hd)) {
		ArrayList<Integer> al = mp.get(hd);
		al.add(head.data);
		mp.put(hd, al);
	}else {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(head.data);
		mp.put(hd, al);
	}
	
	printVerticleOrderUtil(head.left,hd-1,mp);
	printVerticleOrderUtil(head.right,hd+1,mp);
	
}
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticleOrder(root);
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()) {
        	for(int i : entry.getValue()) {
        		System.out.println(i);
        	}
        }
		

	}

}
