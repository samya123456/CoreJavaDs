
public class MaxPathSumMatrix {
	
	public static int findMaxPath(int[][] mat) {
		int max =-1;
		
		
		for (int i = 0; i < mat[0].length; i++) {
			max = Math.max(max, mat[0][i]);
		}
		 
           
		for(int i=1;i<mat.length;i++) {
			max =-1;
			for(int j=0;j<mat[i].length;j++) {
				mat[i][j] +=dfs(i,j,mat);
				max = Math.max(max, mat[i][j]);
			}
		}
		return max;
	}

	private static int dfs(int i, int j, int[][] mat) {
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length) {
			return 0;
		}

		int a = -1;
		int b = -1;
		int c = -1;

		if (isSafe(i - 1, j, mat)) {
			a = mat[i - 1][j];
		}

		if (isSafe(i - 1, j + 1, mat)) {
			b = mat[i - 1][j + 1];
		}
		if (isSafe(i - 1, j - 1, mat)) {
			c = mat[i - 1][j - 1];
		}

		return Math.max(a, Math.max(b, c));

	}
	
	private static boolean isSafe(int i,int j , int[][]mat) {
		if(i<0 || i>=mat.length || j<0 || j>=mat[i].length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		  int mat[][] = { { 1, 2, 3},
		                  { 9 ,8 ,7},
		                  { 4 ,5, 6}};
		  
		  System.out.println(findMaxPath(mat));

	}

}
