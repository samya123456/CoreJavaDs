package com.microsoft;

public class MinimumTimeVisitingAllPoints1266 {
	
	 public int minTimeToVisitAllPoints(int[][] points) {
	        
	        int totalTime = 0;
	        
	        for(int i=1;i<points.length;i++){
	            int x0 = points[i-1][0];
	            int y0 = points[i-1][1];
	            int x1 = points[i][0];
	            int y1 = points[i][1];
	            
	            totalTime += Math.max(Math.abs(x0-x1),Math.abs(y0-y1));
	            
	        }
	        return totalTime;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
