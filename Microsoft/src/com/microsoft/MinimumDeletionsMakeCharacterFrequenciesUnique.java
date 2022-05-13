package com.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumDeletionsMakeCharacterFrequenciesUnique {
	
	  public static int minDeletions(String s) {
	        
		  
	        Map<Character,Integer> wordCountMap = new HashMap<>();
	        
	        for(int i=0;i<s.length();i++){
	            if(wordCountMap.containsKey(s.charAt(i))){
	                int count = wordCountMap.get(s.charAt(i));
	                wordCountMap.put(s.charAt(i),count+1);
	            }else{
	                 wordCountMap.put(s.charAt(i),1);
	            }
	        }
	       List<Map.Entry<Character, Integer>> entryList = new ArrayList<Map.Entry<Character, Integer>>(wordCountMap.entrySet());
	        
	        
	        Collections.sort(entryList , new Comparator<Map.Entry<Character,Integer>>(){
	            
	            public int compare(Map.Entry<Character,Integer> entry1 , Map.Entry<Character,Integer> entry2){
	                if(entry1.getValue()<entry2.getValue()){
	                    return 1;
	                }else{
	                    return -1;
	                }
	            }
	            
	        });
	       
	        
	        
	        int count =0;
	        Set<Integer> set = new HashSet<>();
	        
	        for(int i=0;i<entryList.size();i++){
	            int maxFrequency = entryList.get(i).getValue();
	            while(maxFrequency>0){
	                if(set.contains(maxFrequency)){
	                    maxFrequency--;
	                    count++;
	                 }else{
	                    break;
	                }
	            }
	            
	            set.add(maxFrequency);
	        }
	        
	        return count; 
	    }

	public static void main(String[] args) {
		String input ="aaabbbcc";
		
		System.out.println(minDeletions(input));
	}

}
