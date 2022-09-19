package com.dynamic.newpkg;

public class CountSquareSubmatricesAllOnes1277 {
	
	
	 public static int countSquares(int[][] matrix) {
	        
	        int n = matrix.length;
	        int m = matrix[0].length;
	        int[][] dp = new int[n+1][m+1];
	        
	        for(int i =1;i<=n;i++){
	            for(int j =1;j<=m;j++){
	                
	                if(matrix[i-1][j-1] == 1){
	                    dp[i][j] = 1+ Math.min(dp[i-1][j] , Math.min(
	                    dp[i][j-1],dp[i-1][j-1]));
	                }
	            }
	        }
	        
	        int sum =0;
	        
	        for(int i =0;i<n+1;i++){
	            for(int j =0;j<m+1;j++){
	                sum += dp[i][j];
	            }
	        }
	        
	        return sum;
	        
	    }

	public static void main(String[] args) {
		int[][] matrix =
			{
				   {0,1,1,1},
				   {1,1,1,1},
				   {0,1,1,1}
			};
		
		System.out.println(countSquares(matrix));
		
		

	}

}
