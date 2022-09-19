package com.microsoft;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	 public static boolean isIsomorphic(String s, String t) {
	       Map<Character,Character> mapST = new HashMap<>(); 
	       Map<Character,Character> mapTS = new HashMap<>();  
	        
	        if(s.length()!=t.length()){
	            return false;
	        }
	        for(int i=0;i<s.length();i++){
	            char chS = s.charAt(i);
	            char chT = t.charAt(i);
	            
	            if( (mapST.containsKey(chS) && mapST.get(chS) != chT) ||
	                (mapTS.containsKey(chT) && mapTS.get(chT) != chS)){
	                return false;
	            }
	            
	            mapST.put(chS,chT);
	            mapTS.put(chT,chS);
	        }
	        return true;
	    }

	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		
		
		System.out.println(isIsomorphic(s,t));

	}

}
