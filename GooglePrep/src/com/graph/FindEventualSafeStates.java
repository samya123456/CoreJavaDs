package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates {
	
	public static List<Integer> eventualSafeNodes(int[][] graph) {
        
	      int n = graph.length;
	      Map<Integer,Boolean> safeMap = new HashMap<>();
	      List<Integer> op = new ArrayList<Integer>();
	        
	        for(int i=0;i<n;i++){
	            if(dfs(i,graph,safeMap)){
	                op.add(i);
	            }
	        }
	        
	        return op;
	        
	    }
	
	private static boolean dfs(int index,int[][] graph, Map<Integer,Boolean> safeMap){
        if(safeMap.containsKey(index)){
            return safeMap.get(index);
        }
        safeMap.put(index,false);
        
        int[] childs = graph[index];
        
        for(int i=0;i<childs.length;i++){
            if(!dfs(childs[i],graph,safeMap)){
                safeMap.put(index,false);
                return false;
            }
        }
        safeMap.put(index,true);
        return true;
    }

	public static void main(String[] args) {
		int[][] graph = {{1,2},{2,3},{5},{0},{},{}};
		System.out.println(eventualSafeNodes(graph));

	}

}
