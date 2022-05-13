package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindAndReplaceStringLeetCode833 {
	
	 public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets){
		    int n = s.length();
	        int match[]  = new int[n];
	        Arrays.fill(match, -1);
	        
	        for(int i=0;i<indices.length;i++) {
	        	int ix = indices[i];
	        	if(s.substring(ix, ix+sources[i].length()).equals(sources[i])) {
	        		match[ix] =i;
	        	}
	        }
	        
	        return "";
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcd";
		int[] indices = {0, 2};
		String[] sources = {"a", "cd"};
		String[] targets = {"eee", "ffff"};
		
		System.out.println(findReplaceString(s,indices,sources,targets));
		
		 Map<Integer,Integer> map = new TreeMap<>();
		 List<Map.Entry<Integer,Integer>> list = new ArrayList<> (map.entrySet());
		
	}

}
