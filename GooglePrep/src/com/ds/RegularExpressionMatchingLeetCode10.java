package com.ds;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatchingLeetCode10 {
	 public boolean isMatch(String s, String p) {
	        int n = s.length();
	        int m = p.length();
	        Map<String,Boolean> map = new HashMap<>();
	        return dfs(0,0,n,m,s,p,map);
	        
	        
	    }
	 
	 public boolean dfs(int i,int j,int n,int m ,String s,String p, Map<String,Boolean> map){
	        if(map.containsKey(i+"-"+j)){
	            return map.get(i+"-"+j);
	        }
	        
	        if(i>=n && j>=m){
	            return true;
	        }
	        
	        if(j>=m){
	            return false;
	        }
	        
	        boolean match = (i<n) && (s.charAt(i)==p.charAt(j) || p.charAt(j) =='.');
	        if((j+1<m) &&  p.charAt(j+1)=='*'){
	            boolean value = dfs(i,j+2,n,m,s,p,map) || (match &&  dfs(i+1,j,n,m,s,p,map));
	            map.put(i+"-"+j,value);
	            return map.get(i+"-"+j);
	        }
	        
	        if(match){
	            boolean value=  dfs(i+1,j+1,n,m,s,p,map);
	            map.put(i+"-"+j,value);
	            return map.get(i+"-"+j);
	        }
	        map.put(i+"-"+j,false);
	        return false;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
