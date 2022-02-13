package com.example.tree;

public class MaximumPathSumMatrix {

	// final static int N=100;
	static int n = 4;
	static int m = 6;
	static int a[][] = { { 10, 10, 2, 0, 20, 4 }, { 1, 0, 0, 30, 2, 5 }, { 0, 10, 4, 0, 2, 0 }, { 1, 0, 2, 20, 0, 4 } };
	static int[][] dp = new int[n][m];
	static int visited[][] = new int[n][m];
	static int current_sum = 0;
	static int total_sum = 0;

	public static int maximumPathSum(int mat[][]) {
		int res = -1;

		for (int i = 0; i < m; i++) {
			res = Math.max(res, mat[0][i]);

		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (j > 0 && j < m - 1) {
					mat[i][j] += Math.max(Math.max(mat[i - 1][j], mat[i - 1][j - 1]), mat[i - 1][j + 1]);
				} else if (j > 0) {
					mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j - 1]);
				} else if (j < m - 1) {
					mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j + 1]);
				}

				res = Math.max(res, mat[i][j]);
			}
			
		}
		return res;

	}

	public static void main(String[] args) {

		int op = maximumPathSum(a);
		System.out.println(op);

	}

}
