package com.practise.Tree;

import java.util.Stack;

public class SpiralRotations {

	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	void printSpiral(Node node) {
		if (node==null) return ;
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.add(node);
		
		while(!s1.empty() || !s2.empty()) {
			while(!s1.empty()) {
				Node temp = s1.pop();
				
				System.out.println(temp.data);
				
				if(temp.left!=null) {
					s2.add(temp.left);
				}
				if(temp.right!=null) {
					s2.add(temp.right);
				}
			}
			while(!s2.empty()) {
				Node temp = s2.pop();
				
				System.out.println(temp.data);
				
				if(temp.left!=null) {
					s1.add(temp.left);
				}
				if(temp.right!=null) {
					s1.add(temp.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
