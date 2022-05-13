package com.microsoft;

import java.util.*;

public class ReorderRoutesMakeAllPathsLeadCityZero {
	static class pair{
	    int node;
	    boolean status;
	    pair(int node, boolean status){
	      this.node = node;
	      this.status = status;
	    }
	  }
	
	public static int minReorder(int n, int[][] connections) {
	       
	        List<List<pair>> list = new ArrayList<>();
	        
	        for(int i = 0;i<n;i++){
	          list.add(new ArrayList<>());
	        }
	        
	        boolean[] visited  = new boolean[n];
	        for(int[] c : connections){
	          list.get(c[0]).add(new pair(c[1], true));
	          list.get(c[1]).add(new pair(c[0], false));
	        }
	 
	       return dfs(0, list, visited);
	    }
	
	
        
        
	 public static int dfs(int i, List<List<pair>> list, boolean[] visited){
		    int k = 0;
		     if(visited[i]){
		    	 return 0; 
		     }
		   visited[i] = true;
		    
		     for(pair p: list.get(i)){
		        
		       if(p.status==true && !visited[p.node]) {
		    	   k++;
		       }
		       k+=dfs(p.node, list, visited);
		     }
		    return k;
		  }

	public static void main(String[] args) {
		int connections[][] = {{0,1},{1,3},{2,3},{4,0},{4,5}};
		
		System.out.println(minReorder(6,connections));

	}

}
