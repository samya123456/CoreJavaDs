package com.ds;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGridwithObstaclesElimination {
	
	 public int shortestPath(int[][] grid, int k) {
	        int n = grid.length;
	        int m = grid[0].length;
	        boolean[][][] visited = new boolean[n][m][k+1];
	        Queue<int[]> queue = new LinkedList<>();
	        int steps =0;
	        
	        int[] starting = new int[]{0,0,k};
	        visited[0][0][k] =true;
	        queue.add(starting);
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int p=0;p<size;p++){
	                int[] current = queue.poll();
	                int i = current[0];
	                int j = current[1];
	                if(i==n-1 && j==m-1){
	                    return steps;
	                }
	                int ObsBalance = current[2];
	                bfs(i+1,j,ObsBalance,n,m,grid,visited,queue);
	                bfs(i-1,j,ObsBalance,n,m,grid,visited,queue);
	                bfs(i,j+1,ObsBalance,n,m,grid,visited,queue);
	                bfs(i,j-1,ObsBalance,n,m,grid,visited,queue);
	               
	            }
	              ++steps;
	        }
	        
	        return -1;
	    }
	    
	    private void bfs(int i,int j,int ObsBalance,int n,int m,int[][] grid,
	                     boolean[][][] visited,Queue<int[]> queue){
	        if(i<0 ||i>=n || j<0 ||j>=m ){
	            return;
	        }
	        if(grid[i][j]==0 && !visited[i][j][ObsBalance]){
	            visited[i][j][ObsBalance] =true;
	            queue.offer(new int[]{i,j,ObsBalance});
	            
	        }else if(grid[i][j]==1 && ObsBalance >0 && !visited[i][j][ObsBalance-1]){
	            visited[i][j][ObsBalance-1] =true;
	            queue.offer(new int[]{i,j,ObsBalance-1});
	           
	        }
	    }

	public static void main(String[] args) {
		

	}

}
