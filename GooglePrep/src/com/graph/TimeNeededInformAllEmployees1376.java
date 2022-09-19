package com.graph;

import java.util.ArrayList;
import java.util.List;


public class TimeNeededInformAllEmployees1376 {
	static int totaltime =0;
	static int max =0;

	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

		List<Integer>[] adj_List = new ArrayList[n];

		for (int i = 0; i < n; i++) {

			if (i != headID) {
				if (adj_List[manager[i]] != null) {
					List<Integer> employees = adj_List[manager[i]];
					employees.add(i);
					adj_List[manager[i]] = employees;
				} else {
					List<Integer> employees = new ArrayList<Integer>();
					employees.add(i);
					adj_List[manager[i]] = employees;
				}
			}
		}
		
		dfs(headID,adj_List,informTime);
		return max;

	}
	
	private static void dfs(int manager ,List<Integer>[] adj_List , int[] informTime) {
		    max = Math.max(max,totaltime);
			List<Integer> children = adj_List[manager];
			
			if(children!=null) {
				for(int i =0;i<children.size();i++) {
					
					totaltime += informTime[manager];
		
					dfs(children.get(i),adj_List,informTime);
					
					totaltime -= informTime[manager];
				}
			}
		
		
		 
	}

	public static void main(String[] args) {
		int n = 15 ;
		int headID = 0;
		int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
		int informTime[] = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
		
		System.out.println(numOfMinutes(n,headID,manager,informTime));

	}

}
