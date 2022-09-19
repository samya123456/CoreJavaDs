package com.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringKUniqueCharacters {
	
	public static int longestkSubstr(String s, int k) {
       int j=0;
       int i =0;
       Map<Character,Integer> map = new HashMap<>();
       int maxLength=0;
       
       while(j<s.length()) {
    	   
    	   if(!map.containsKey(s.charAt(j))) {
    		   map.put(s.charAt(j),1);
    		  
    	   }else {
    		   map.put(s.charAt(j),map.get(s.charAt(j))+1);
    	   }
    	   
    	   if(map.size()==k) {
    		   maxLength = Math.max(maxLength, j-i+1);
    		  
    		  
    	   }else if(map.size()>k) {
    		   
    		   while(map.size() > k && i< s.length()) {
    			   
    			   
    	    		  int count = map.get(s.charAt(i));
    	    		  if(count -1 > 0) {
    	    			  map.put(s.charAt(i), count-1);
    	    			  i++;
    	    		  }else if (count-1 ==0){
    	    			  map.remove(s.charAt(i));
    	    			  i++;
    	    			  
    	    		  }
    	    		  
    	    		  
    	    	   
    			  
    			   
    		   }
    	   }
    	   
    	   j++;
       }
       
       return maxLength;
    }

	public static void main(String[] args) {
		String s ="aabacbebebe";
		int k = 3;
		System.out.println(longestkSubstr(s,k));

	}

}
