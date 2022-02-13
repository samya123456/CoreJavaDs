package com.example.tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class ButtomViewTree {
	
	static class Node {
		Node left,right;
		int data;
		int hd;
		
		Node(int data){
			this.data = data;
			hd = Integer.MAX_VALUE;
			left=right=null;
		}
	}
	
	public static void buttomView(Node root) {
		if(root==null) {
			return;
		}
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int hd =0;
		Queue<Node> queue = new LinkedList<Node>();
		root.hd =hd;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			
			Node temp = queue.remove();
			hd = temp.hd;
			map.put(hd, temp.data);
			
			if(temp.left!=null) {
				temp.left.hd = hd-1;
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				temp.right.hd = hd+1;
				queue.add(temp.right);
			}
			
		}
		
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			System.out.println(entry.getValue());
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
	        
	        buttomView(root);
		

	}

}
