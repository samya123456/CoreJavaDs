package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
	
	static class Node {
		Node left,right;
		int data;
		int hd;
		
		
		Node(int data){
			this.data = data;
			this.hd =0;
			left=right=null;
		}
	}
	
	public static int maxWidth(Node root) {
		
		Queue<Node > queue = new LinkedList<Node>();
		
		if(root==null) {
			return 0;
		}
		root.hd=0;
		queue.add(root);
		int max_node =1;
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				queue.add(temp.right);
			}
			
			max_node = Math.max(max_node, queue.size());
			
		}
		return max_node;
		
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(3);
		
		System.out.println(maxWidth(root));

	}

}
