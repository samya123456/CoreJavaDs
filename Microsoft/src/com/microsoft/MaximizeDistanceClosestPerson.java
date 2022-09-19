package com.microsoft;

public class MaximizeDistanceClosestPerson {
	
	public int maxDistToClosest(int[] seats) {
        int maxDist =0;
        int l = -1;
        int n = seats.length;
        
        for(int i =0;i<n;i++){
            if(seats[i] ==1){
                if(l ==-1){
                  maxDist =i;  
                }else {
                    maxDist = Math.max(maxDist, (i-l)/2);
                }
                l =i;
            }
        }
        
        if(seats[n-1] ==0){
            maxDist = Math.max(maxDist, n-1-l);
        }
        return maxDist;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
