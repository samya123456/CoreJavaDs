package com.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class PrintVerticalOrderTree {
	
	static Map<Integer, List<Integer>> map = new TreeMap<>();
	
	public static class Node{
	    int data;
	    Node left, right;
	    int hd;
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	public static void printVerticalOrder(Node root,int hd) {
		if(root==null) {
			return;
		}
		if(map.containsKey(hd)) {
			List<Integer> al = map.get(hd);
			al.add(root.data);
			map.put(hd, al);
		}
		else {
			List<Integer> al = new ArrayList<>();
			al.add(root.data);
			map.put(hd, al);
			
		}
		
		printVerticalOrder(root.left,hd-1);
		printVerticalOrder(root.right,hd+1);
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
        printVerticalOrder(root,1);
        
        Set<Map.Entry<Integer,List<Integer>>> st = map.entrySet();
        for(Map.Entry<Integer,List<Integer>>entry: st) {
        	for(Integer i : entry.getValue()) {
        		System.out.println(i);
        	}
        }


	}

}
