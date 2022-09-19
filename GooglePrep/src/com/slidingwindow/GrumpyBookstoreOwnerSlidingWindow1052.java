package com.slidingwindow;

public class GrumpyBookstoreOwnerSlidingWindow1052 {
	
	 public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
	        
	        int global = 0;
	        
	        for(int i =0 ;i<customers.length;i++){
	            if(grumpy[i] ==0){
	                global += customers[i];
	                
	            }
	        }
	        
	        int start =0;
	        int end =0;
	        int max =0;
	        while(end <customers.length){
	            
	           
	            
	            if(grumpy[end] ==1){
	                 global += customers[end];
	            }
	            if(end -start+1 < minutes){
	                end++;
	            }
	            
	            else if(end -start+1 == minutes){
	                max = Math.max(max ,global);
	                
	                if(grumpy[start] ==1){
		                   global -= customers[start];  
		            }
	                
	                start++;
	                end++;
	            }
	            
	        }
	        
	        return max;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int customers[] = {1,0,1,2,1,1,7,5};
		int grumpy[] =    {0,1,0,1,0,1,0,1};
		int minutes = 3;
		
		System.out.println(maxSatisfied(customers,grumpy,minutes));

	}

}
