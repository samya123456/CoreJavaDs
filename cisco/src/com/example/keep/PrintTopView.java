package com.example.keep;

import java.util.*;


public class PrintTopView {
	
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
	static Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();
	
	
	public static void printTopView(Node head) {
		printTopViewUtil(head);
	}

	private static void printTopViewUtil(Node head) {
		if(head==null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		head.hd=1;
		q.add(head);
		while(!q.isEmpty()) {
			
			Node temp = q.remove();
			int  hd = temp.hd;
			if(!mp.containsKey(hd)) {
				mp.put(hd, temp.data);
			}
			
			if(temp.left!=null) {
				temp.left.hd = hd-1;
				q.add(temp.left);
			}
			if(temp.right!=null) {
				temp.right.hd = hd+1;
				q.add(temp.right);
			}
		}
		
		
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        System.out.println(
            "Following are nodes in top view of Binary Tree");
        printTopView(root);
        for(Map.Entry<Integer, Integer>entry : mp.entrySet()) {
        	System.out.println(entry.getValue());
        }

	}

}
