package com.microsoft;

public class MaximizeDistanceClosestPerson849 {
	
	 public int maxDistToClosest(int[] seats) {
         int left =-1;
         int right =-1;
         int max =0;
        
        for(int i =0; i<seats.length;i++){
            
            if(seats[i] ==1){
                
                if(left ==-1){
                    left =i;
                    max = Math.max(max,i);
                    
                }else if(right ==-1){
                    right =i;
                    max = Math.max(max ,(right-left)/2);
                }else {
                    left =right;
                    right =i;
                    max = Math.max(max ,(right-left)/2);
                }
            } else if( i == seats.length -1){
                max = Math.max(max ,i- Math.max(right,left));
            }
        }
        
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] seats = {1,0,0,0,1,0,1};

	}

}
