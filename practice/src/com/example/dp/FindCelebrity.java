package com.example.dp;

public class FindCelebrity {
	
	static int[][] M = { { 0, 0, 1, 0 },
		 	   			 { 0, 0, 1, 0 },
		 	   			 { 0, 0, 0, 0 },
		 	   			 { 0, 0, 1, 0 } };
	
	public static int findCelebrity(int n) {
		
		int candidate =0;
		
		for(int i=1;i<n;i++) {
			if(M[candidate][i]==1) {
				candidate =i;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(i!=candidate && (M[candidate][i]==1 || M[i][candidate]==0)) {
				return -1;
			}
		}
		
		return candidate;
		
	}

	public static void main(String[] args) {
		
		System.out.println(findCelebrity(4));
		

	}

}
