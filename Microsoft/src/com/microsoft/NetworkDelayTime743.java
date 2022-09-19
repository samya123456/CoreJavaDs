package com.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {
	
	 static class Pair implements Comparable<Pair>{
	        int v;
	        int wt;
	        
	        Pair(int v ,int wt){
	            this.v =v;
	            this.wt =wt;
	        }
	        
	        public int compareTo(Pair other){
	            
	            return this.wt -other.wt;
	        }
	    }
	 
	 
	 //Time complexity: O(Nlog(N) + E), Space complexity: O(N + E)
	    
	public static int networkDelayTime(int[][] times, int n, int k) {
	        ArrayList<ArrayList<Integer>> adj[] = new ArrayList[n+1];
	       
	        for(int i =0;i<times.length;i++){
	        	
	            int parent = times[i][0];
	            int child = times[i][1];
	            int wt = times[i][2];
	            
	            if(adj[parent]!=null){
	                ArrayList<ArrayList<Integer>> childList = adj[parent];
	                ArrayList<Integer> childNode = new ArrayList<Integer>();
	                childNode.add(child);
	                childNode.add(wt);
	                childList.add(childNode);
	                adj[parent]=childList;
	            }else{
	                 ArrayList<ArrayList<Integer>> childList = new ArrayList<>();
	                 ArrayList<Integer> childNode = new ArrayList<Integer>();
	                 childNode.add(child);
	                 childNode.add(wt);
	                 childList.add(childNode);
	                 adj[parent]=childList;
	                
	            }
	        }
	        
	         int[] ans = new int[n+1];
	         dijkstra(n+1,adj,k,ans);
	         int max = 0;
	        
	            for(int i =1;i<=n;i++){
	                if(ans[i] == Integer.MAX_VALUE){
	                    return -1;
	                }
	                max = Math.max(max,ans[i]);
	            }
	        
	        return max;
	        
	    }
	    
   private static void dijkstra(int V , ArrayList<ArrayList<Integer>> adj[],int S,int[] ans){
	        boolean visited[] =new boolean[V];
	        PriorityQueue<Pair> q =new PriorityQueue<>();
	        Arrays.fill(ans, Integer.MAX_VALUE);
	        ans[S] =0;
	        
	        q.add(new Pair(S,0));
	        
	        while(!q.isEmpty()){
	            Pair cur = q.remove();
	            int u =cur.v;
	            
	            if(visited[u]){
	                continue;
	            }
	            visited[u] =true;
	            ArrayList<ArrayList<Integer>> neighbours = adj[u];
	            if(neighbours!=null) {
		            for(ArrayList<Integer> list : neighbours){
		                int index = list.get(0);
		                int wt = list.get(1);
		                
		                if(ans[index] > ans[u] + wt){
		                    
		                    ans[index] = ans[u] + wt;
		                    q.add(new Pair(index,ans[index]));
		                }
		            }
	            }
	        }
	        
	    }
	   

	public static void main(String[] args) {
		int[][] times ={{2,1,1},{2,3,1},{3,4,1}};
		int n = 4; 
		int k = 2;
		

		
		System.out.println(networkDelayTime(times,n,k));

	}

}
