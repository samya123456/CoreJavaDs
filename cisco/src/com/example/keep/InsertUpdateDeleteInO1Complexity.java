package com.example.keep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InsertUpdateDeleteInO1Complexity {
	
	ArrayList<Integer> list;
	Map<Integer,Integer> map;
	
	public InsertUpdateDeleteInO1Complexity() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer,Integer>();
	}
	
	void add (int item) {
		if(map.get(item) !=null) {
			return;
		}
		
		int x = list.size();
		map.put(item, x);
		list.add(item);
	}
	
	
	void remove(int item) {
		Integer index = map.get(item);
		if(index==null) {
			return;
		}
		Integer lastItem = list.get(list.size()-1);
		Collections.swap(list, index, list.size()-1);
		map.remove(item);
		list.remove(list.size()-1);
		map.put(lastItem, index);
		
	}
	
	public Integer get(int index) {
		return list.get(index);
	}
	
	public Integer search (int item) {
		return map.get(item);
	}

	public static void main(String[] args) {
		

	}

}
