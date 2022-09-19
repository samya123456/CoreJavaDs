package com.dynamic.newpkg;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {

		int largest = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], 
							 dp[i - 1][j - 1]));
				}

				if (largest < dp[i][j]) {
					largest = dp[i][j];
				}
			}
		}
		
		return largest*largest;
	}

	public static void main(String[] args) {
		
		
		

	}

}
