package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers116_Microsoft {

	static class Node {
		int val;
		Node left;
		Node right;
		Node next;

		Node(int val) {
			this.val = val;
			left = right = next = null;
		}
	}

	public static Node connectUsingQueue(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node temp = root;
		while (!queue.isEmpty()) {

			int size = queue.size();
			Node prev = null;
			while (size-- > 0) {
				temp = queue.poll();
				temp.next = prev;
				prev=temp;
				if (temp.right != null) {
					queue.add(temp.right);
				}
				if (temp.left != null) {
					queue.add(temp.left);
				}
				
			}
			
			
		}

		return root;

	}
	
	public static Node connectUsingWithOutQueue(Node root) {
		
		if(root==null) {
			return null;
		}
		Node current = root;
		while(current.left!=null) {
			Node temp = current;
			while(current!=null) {
				current.left.next = current.right;
				current.right.next = current.next ==null?null:current.next.left;
				current = current.next;
			}
			current = temp.left;
			
		}
		

		return root;

	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root = connectUsingWithOutQueue(root);

	}

}
