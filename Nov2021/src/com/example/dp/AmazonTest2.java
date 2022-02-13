package com.example.dp;

import java.util.*;

public class AmazonTest2 {

	public static void main(String[] args) {
		String input ="ttccccdffgkkkkk";
		  Map<Character,Integer> letterCount = new TreeMap();
          for(int i=0;i<input.length();i++){
              char ch = input.charAt(i);
              if(letterCount.containsKey(ch)){
                  int count = letterCount.get(ch);
                  letterCount.put(ch,count+1);
              }else{
                  letterCount.put(ch,1);
              }
          }
          List<Map.Entry<Character,Integer>> list =sortByValue(letterCount);
          StringBuffer br = new StringBuffer("");
          
          //Set<Integer> intset = new HashSet<Integer>();
        		  
          for(Map.Entry<Character,Integer> entry:list){
        	  //if(!intset.contains(entry.getValue())) {
        		  br.append(entry.getKey());
                  br.append(entry.getValue());
                //  intset.add(entry.getValue());
        	 // }
                 
          }
          System.out.println(br.toString()); 


  
		// TODO Auto-generated method stub

	}
	
	 private static List<Map.Entry<Character,Integer>> sortByValue(Map<Character,Integer>letterCount){
	        Set<Map.Entry<Character,Integer>> set = letterCount.entrySet();
	        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(set);

	        Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>()
	        {
	            public int compare(Map.Entry<Character,Integer> o1 ,Map.Entry<Character,Integer> o2){
	                return (o2.getValue().compareTo( o1.getValue()));
	            }
	        }
	        
	        
	        );

	        return list;
	    }

}
