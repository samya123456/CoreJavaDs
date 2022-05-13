package com.practise.Tree;

public class PrintLeftViewBTree {
    int max_level =0;
	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public void printLeftView(Node root, int level) {
		if (root == null)
			return;
		if(max_level<level) {
			System.out.println(root.data);
			max_level = level;
		}
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
