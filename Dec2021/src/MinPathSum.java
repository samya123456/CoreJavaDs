
public class MinPathSum {
	
	public static int minPathSum(int[][] grid) {
		int n= grid.length;
		int m=grid[0].length; 
		int[][] dp = new int[n][m];
		dp[0][0] =grid[0][0];
		for(int i=1;i<n;i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int i=1;i<m;i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		return dp[n-1][m-1];
	}
	
	public static int maxPathSum(int mat[][]) {
		int n = mat.length;
		int m = mat[0].length;
		int res =-1;
		for(int i=0;i<m;i++) {
			res = Math.max(res, mat[0][i]);
		} 
		
		for(int i=1;i<n;i++) {
			res = -1;
			for(int j=0;j<m;j++) {
				
				if(j>0 && j<m-1) {
					mat[i][j] +=Math.max(mat[i-1][j], Math.max(mat[i-1][j-1], mat[i-1][j+1]));
				}
				else if(j>0) {
					mat[i][j] +=Math.max(mat[i-1][j], mat[i-1][j-1]);
				}else if(j<m-1) {
					mat[i][j] +=Math.max(mat[i-1][j], mat[i-1][j+1]);
				}
				res = Math.max(res, mat[i][j]);
			}
			
		}
		return res;
	}

	public static void main(String[] args) {
		

	}

}
