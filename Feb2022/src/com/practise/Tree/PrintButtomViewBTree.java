package com.practise.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PrintButtomViewBTree {
	
	class Node {
		int data;
		int hd;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}
	
	public void printButtom(Node root) {
		if(root==null) return;
		
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		
		root.hd =0;
		queue.add(root);
		
		while(queue.isEmpty()) {
			Node temp =queue.poll();
			int hd = temp.hd;
			map.put(hd, root.data);
			if(temp.left!=null) {
				temp.left.hd = hd-1;
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				temp.right.hd = hd+1;
				queue.add(temp.right);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
