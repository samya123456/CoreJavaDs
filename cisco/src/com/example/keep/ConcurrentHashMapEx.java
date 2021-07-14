package com.example.keep;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConcurrentHashMap<Integer, String> m
        = new ConcurrentHashMap<>();
		
		m.put(100, "Hello");
        m.put(101, "Geeks");
        m.put(102, "Geeks");
        
        
        for(Map.Entry<Integer, String> entry : m.entrySet()) {
        	System.out.println(entry.getKey() +" "+ entry.getValue());
        }
 

	}

}
