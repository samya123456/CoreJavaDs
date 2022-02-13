
public class MinimumPathSumMatrix {

	public static int minPathSum(int[][] grid) {

		int M = grid.length;
		int N = grid[0].length;

		int dp[][] = new int[M][N];
		dp[0][0] = grid[0][0];
		for(int i=1;i<M;i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int j=1;j<N;j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[i].length; j++) {
				
						dp[i][j] = grid[i][j]+ Math.min(dp[i-1][j], dp[i][j-1]);
					
				}
			}
		
		return dp[M-1][N-1];

	}

	public static int minPathSumRecUtil(int[][] grid, int i, int j, int M, int N) {
		if (i == grid.length - 1 && j == grid.length - 1) {
			return grid[i][j];
		} else if (i == grid.length - 1) {
			return grid[i][j] + minPathSumRecUtil(grid, i, j + 1, M, N);
		} else if (j == grid.length - 1) {
			return grid[i][j] + minPathSumRecUtil(grid, i + 1, j, M, N);
		} else {
			return grid[i][j]
					+ Math.min(minPathSumRecUtil(grid, i + 1, j, M, N), minPathSumRecUtil(grid, i, j + 1, M, N));
		}
	}

	public static void main(String[] args) {
		int grid[][] = { { 1, 3, 1 }, 
						 { 1, 5, 1 }, 
						 { 4, 2, 1 } };

		System.out.println(minPathSum(grid));

	}

}
