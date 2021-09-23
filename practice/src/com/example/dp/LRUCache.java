package com.example.dp;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	static class Node{
		int key;
		int val;
		Node prev;
		Node next;
	}
	
	Map<Integer, Node> map = new HashMap<>();
	int capacity;
	Node tail;
	Node head;
	public  LRUCache(int capacity) {
		this.capacity = capacity;
		
		head.next =tail;
		tail.prev =head;
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			add(node);
			return node.val;
		}else {
			return -1;
		}
	}
	
	public void put(int key,int val) {
		if(map.containsKey(key)) {
			remove(map.get(key));
		}
		if(map.size()==capacity) {
			remove(tail.prev);
		}
		
		Node node = new Node();
		node.key =key;
		node.val =val;
		
		add(node);
	}
	
	private void remove(Node node) {
		map.remove(node.key);
		node.next.prev = node.next;
		node.prev.next = node.prev;
		
	}
	
	private void add(Node node) {
		map.put(node.key, node);
		head.next = node;
		node.prev = head;
		node.next = head.next;
		node.next.prev =node; 
	}
	

	public static void main(String[] args) {
		

	}

}
