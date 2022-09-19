package com.ds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak139 {
	
	    static Map<String,Boolean> mem = new HashMap<>();
	    public static boolean wordBreak(String s, List<String> wordDict) {
	       if(mem.containsKey(s)){
	          return mem.get(s);
	       }
	       if( wordDict.contains(s)){
	           mem.put(s,true);
	           return true;
	       }
	        
	          
	      for(int i =1;i<=s.length();i++){
	          
	          if(wordDict.contains(s.substring(0,i)) 
	             && wordBreak(s.substring(i),wordDict)){
	              mem.put(s.substring(0,i),true);
	              return true;
	          }
	      }
	        
	        mem.put(s,false);
	        return false;
	    
	      
	    }
	    

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = List.of("leet","code");
		System.out.println(wordBreak(s,wordDict));
		

	}

}
