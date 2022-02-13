package com.example.dp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LRUCache {
	Set<Integer> cache;
	int capacity;
	
	LRUCache(int capacity){
		this.capacity = capacity;
		cache = new LinkedHashSet<Integer>(capacity);
	}
	
	public boolean get(int key) {
		if(cache.contains(key)) {
			cache.remove(key);
			cache.add(key);
			return true;
		}
		return false;
	}
	
	public void refer(int element) {
		if(!get(element)) {
			put(element);
		}
	}
	
	public  void put(int element) {
		if(cache.size()==capacity) {
			int firstkey = cache.iterator().next();
			cache.remove(firstkey);
			
		}
		
		cache.add(element);
	}
	
	public void display() {
		//LinkedHashSet<Integer> temp = new LinkedHashSet<Integer>(cache);
		
		List<Integer> list = new ArrayList<Integer>(cache);
		for(int i =list.size()-1;i>=0;i--) {
			System.out.println(list.get(i));
		}
	}
	
 		
	

	public static void main(String[] args) {
		LRUCache ca  = new LRUCache(4);
		ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();

	}

}
