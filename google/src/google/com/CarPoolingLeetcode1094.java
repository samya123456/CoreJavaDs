package google.com;

import java.util.Arrays;
import java.util.Comparator;

public class CarPoolingLeetcode1094 {
	
	public static boolean carPooling(int[][] trips, int capacity) {
		
		    int n = trips.length;
	        int[][] breakTrip  = new int[2*n][3];
	        
	        for(int i=0;i<n;i++){
	            int numPassengers = trips[i][0];
	            int from = trips[i][1];
	            int to = trips[i][2];
	            breakTrip[2*i][0] = from;
	            breakTrip[2*i][1] = 1;//entering
	            breakTrip[2*i][2] = numPassengers;
	            
	            breakTrip[(2*i)+1][0] = to;
	            breakTrip[(2*i)+1][1] = 0;//leaving
	            breakTrip[(2*i)+1][2] = numPassengers;
	            
	        }
	        sortArrayBasedOnColumnNumber(breakTrip,1);
	       
	        for(int i=0;i<2*n;i++){
	            int enterOrLeave = breakTrip[i][1];
	            if(enterOrLeave ==1){
	                capacity = capacity -  breakTrip[i][2];
	            }else{
	                capacity = capacity +  breakTrip[i][2];
	            }
	            
	            if(capacity<0){
	                return false;
	            }
	        }
	        return true;
    }
    
    private static void sortArrayBasedOnColumnNumber(int[][] arr,int columnNo){
        Arrays.sort(arr ,new Comparator<int[]>(){
            
            public int compare(int[] first,int[] second){
                if(first[columnNo-1]>second[columnNo-1]){
                    return 1;
                }else if(first[columnNo-1]==second[columnNo-1]){
                    if(first[columnNo]>second[columnNo]) {
                    	return 1;
                    }else {
                    	return -1;
                    }
                }else {
                	return -1;
                }
            }
            
        });
    }

	public static void main(String[] args) {
		int[][] trips = {{2,1,5},{3,3,7}};
		System.out.println(carPooling(trips,3));;
		
		/*{{1,1,2},
		 * {5,0,2},
		 * {5,1,3},
		 * {7,0,3} */

	}

}
