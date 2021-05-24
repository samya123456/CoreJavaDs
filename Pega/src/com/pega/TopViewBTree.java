package com.pega;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopViewBTree {
	
	static class Node {
	    int data;
	    Node left, right;
	    int hd;
	 
	    public Node(int data)
	    {
	        this.data = data;
	        left = right = null;
	        
	    }
	}
	
	static class QueueObj {
        Node node;
        int hd;

        QueueObj(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }
public void printTopView(Node root) {
	Queue<Node> q = new LinkedList<Node>();
	Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	
	if(root==null)
		return;
	q.add(root);
	
	while(!q.isEmpty()) {
		Node temp = q.poll();
		int hd = temp.hd;
		if(!map.containsKey(hd)) {
			map.put(hd, temp.data);
		}
		if(temp.left!=null) {
			temp.left.hd = hd-1;
			q.add(temp.left);
		}
		
       if(temp.right!=null) {
    	   temp.right.hd = hd+1;
			//QueueObj newQueueObj = new QueueObj(temp.node.right,hd+1);
			q.add(temp.right);
		}
	}
	
	for(Entry<Integer, Integer> entry:map.entrySet()) {
		System.out.println(entry.getValue());
	}
}
	public static void main(String[] args) {
		TopViewBTree tree = new TopViewBTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(
            "Following are nodes in top view of Binary Tree");
        tree.printTopView(root);
		

	}

}
