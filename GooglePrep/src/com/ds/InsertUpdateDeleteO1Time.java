package com.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertUpdateDeleteO1Time {
	
	
	List<Integer> list;
	Map<Integer,Integer> map;
	
	public InsertUpdateDeleteO1Time() {
		list = new ArrayList<>();
		map  = new HashMap<>();
	}
	
	public boolean insert(int data) {
		if(map.containsKey(data)) {
			return false;
		}
		int x = list.size();
		map.put(data, x);
		list.add(data);
		return true;
	}
	
	
	public Integer get(int index) {
		return list.get(index);
	}
	
	public void remove(int data) {
		if(!map.containsKey(data)) {
			return;
		}
		
		int index = map.get(data);
		int lastElement = list.get(list.size()-1);
		map.put(lastElement, index);
		map.remove(data);
		Collections.swap(list, index, list.size()-1);
		list.remove(list.size()-1);
	}

	public static void main(String[] args) {
		

	}

}
