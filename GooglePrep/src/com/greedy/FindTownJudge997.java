package com.greedy;

public class FindTownJudge997 {
	
	 public static int findJudge(int n, int[][] trust) {
	        
		  
	       int[] count =new int[n+1];
	        
	        for(int[] arr : trust){
	            count[arr[0]]--;
	            count[arr[1]]++;
	        }
	        
	        for(int i=1;i<=n;i++){
	            if(count[i] ==n-1){
	                return i;
	            }
	        }
	        return -1;
	    }
	
	

	public static void main(String[] args) {
		
		int[][] trust = {{1,3},
				         {1,4},
				         {2,3},
				         {2,4},
				         {4,3}};
		int n =4;
		System.out.println(findJudge(n,trust));

	}

}
