package com.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII210 {
	
	 public static int[] findOrder(int numCourses, int[][] prerequisites) {
	        
         Map<Integer,Set<Integer>> adj = new HashMap<>();
         
         for(int i =0;i<numCourses;i++) {
        	 adj.put(i,new HashSet<Integer>());
         }
         
         for(int i =0;i<prerequisites.length;i++) {
        	 adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
         }
         
         int[] ans = new int[numCourses];
         
         if(detectCycle(adj,numCourses)) {
        	 return ans;
         }
         
         boolean[] visited = new boolean[numCourses];
         
         Stack<Integer> topoSort = new Stack<Integer>();
         
         for(int i =0;i<numCourses;i++) {
        	 if(!visited[i]) {
        		 dfs(adj,i,visited,topoSort);
        	 }
        	 
         }
         
         int i =0;
         while(!topoSort.isEmpty()) {
        	 ans[i++] = topoSort.pop();
         }
        return ans;
       
    }

	private static void dfs(Map<Integer, Set<Integer>> adj, int i, boolean[] visited, Stack<Integer> topoSort) {
		visited[i] =true;
		Set<Integer> adjIndex =adj.get(i);
		List<Integer> adjList = new ArrayList<>(adjIndex);
		
		for(int j =0;j<adjList.size();j++) {
			
			if(!visited[adjList.get(j)]) {
				dfs(adj,adjList.get(j),visited,topoSort);
			}
		}
		topoSort.push(i);
		
		
	}

	private static boolean detectCycle(Map<Integer, Set<Integer>> adj, int numCourses) {

		int[] visited = new int[numCourses];
		
		for(int i =0;i<numCourses;i++) {
			if(visited[i] ==0) {
				if(detectCycle_util(adj,visited,i)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean detectCycle_util(Map<Integer, Set<Integer>> adj, int[] visited, int i) {
		
		if(visited[i] == 1) {
			return true;
		}
		if(visited[i] ==2) {
			return false;
		}
		visited[i] =1;
		
		List<Integer> adjList = new ArrayList<>(adj.get(i));
		
		for(int j =0;j<adjList.size();j++) {
			if(detectCycle_util(adj,visited,adjList.get(j))) {
				return true;
			}
		}
		visited[i] =2;
		return false;
	}

	public static void main(String[] args) {
		int[][] prerequisites = {{1,0},{0,1}};
		int numCourses = 2;
		
		System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));

	}

}
