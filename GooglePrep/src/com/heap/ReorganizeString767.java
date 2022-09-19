package com.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString767 {
	
	 public static String reorganizeString(String s) {
		 
		 Map<Character,Integer> map = new HashMap<>();
		 
		 for(char ch:s.toCharArray()) {
			 map.put(ch,map.getOrDefault(ch, 0)+1);
		 }
		 PriorityQueue<Character> maxHeap = new
				 PriorityQueue<Character>((a,b)->map.get(b)-map.get(a));
		 
		 maxHeap.addAll(map.keySet());
		 StringBuffer br = new StringBuffer();
		 while(maxHeap.size()>1) {
			 Character current = maxHeap.remove();
			 Character next =   maxHeap.remove();
			 br.append(current);
			 br.append(next);
			 
			 map.put(current, map.get(current)-1);
			 map.put(next, map.get(next)-1);
			 
			 if(map.get(current)>0) {
				 maxHeap.add(current) ;
			 }
			 
			 if(map.get(next)>0) {
				 
				 maxHeap.add(next) ;
			 }
			 
			 
		 }
		 
		 if(!maxHeap.isEmpty()) {
			 char last = maxHeap.remove();
			 if(map.get(last)>1) {
				 return "";
				 
			 }
			 br.append(last);
		 }
		 
		 return br.toString();
			 
			 
		 
	 }

	public static void main(String[] args) {
		String s = "aab";
		
		System.out.println(reorganizeString(s));

	}

}
