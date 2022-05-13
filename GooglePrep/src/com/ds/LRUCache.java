package com.ds;

import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	
	
	Map<Integer,Integer> cache = new LinkedHashMap<Integer,Integer>();
	int capacity;
	
	
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		Integer value = cache.get(key);
		
		if(value==null) {
			return -1;
		}
		
		cache.remove(key);
		cache.put(key,value);
		return value;
	}
	
	public void put(int key, int value) {
		
		if(cache.containsKey(key)) {
			cache.remove(key);
			cache.put(key, value);
			return;
		}
		if(cache.size()<capacity) {
			cache.put(key, value);
			return;
		}
		
		if(cache.size()==capacity) {
			List<Map.Entry<Integer,Integer>> list = new ArrayList<>(cache.entrySet());
			int leastKey = list.get(0).getKey();
			cache.remove(leastKey);
			cache.put(key, value);
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
