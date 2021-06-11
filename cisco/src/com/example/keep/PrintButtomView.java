package com.example.keep;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


public class PrintButtomView {
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
	
	
	public void printButtomView(Node head) {
		if (head==null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		head.hd=1;
		q.add(head);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.hd;
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
		
	}

	public static void main(String[] args) {
		 Node root = new Node(20);
	        root.left = new Node(8);
	        root.right = new Node(22);
	        root.left.left = new Node(5);
	        root.left.right = new Node(3);
	        root.right.left = new Node(4);
	        root.right.right = new Node(25);
	        root.left.right.left = new Node(10);
	        root.left.right.right = new Node(14);
	        PrintButtomView tree = new PrintButtomView();
	        System.out.println("Bottom view of the given binary tree:");
	        tree.printButtomView(root);
	        
	        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
	        	System.out.println(entry.getValue());
	        }

	}

}
