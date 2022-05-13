package com.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	
	static class Pair implements Comparable<Pair>{
		int v;
		int wt;
		
		Pair(int v ,int wt){
			this.v =v;
			this.wt =wt;
		}
		
		public int compareTo(Pair o) {
			
			return this.wt -o.wt;
		}
		
	}
	//Time complexity: O(Nlog(N) + E), Space complexity: O(N + E)
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       boolean[] visited = new boolean[V];
       PriorityQueue<Pair> q = new PriorityQueue<Pair>();
       q.add(new Pair(S,0));
        
       int ans[] = new int[V];
       Arrays.fill(ans, Integer.MAX_VALUE);
       ans[S] =0;
       
       while(!q.isEmpty()) {
    	   Pair cur = q.remove();
    	   int u = cur.v;
    	   if(visited[u]) {
    		   continue;
    	   }
    	   
    	   visited[u] =true;
    	   ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
    	   for(ArrayList<Integer> list:neighbours) {
    		   int index = list.get(0);
    		   int weight = list.get(1);
    		   if( ans[index] > ans[u] + weight) {
    			   ans[index] = ans[u] + weight;
    			   q.add(new Pair(index ,  ans[index]));
    		   }
    	   }
       }
       
       return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
