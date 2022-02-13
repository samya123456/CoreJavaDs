
public class MaxPathSumMatrix {

	static int M;
	static int N;

	public static int maxPathSum(int[][] mat) {

		int res = Integer.MIN_VALUE;

		for (int j = 0; j < N; j++) {
			res = Math.max(res, mat[0][j]);
		}

		for (int i = 0; i < M; i++) {
			res = Integer.MIN_VALUE;
			for (int j = 0; j < N; j++) {
				int a = Integer.MIN_VALUE;
				int b = Integer.MIN_VALUE;
				int c = Integer.MIN_VALUE;

				if (isSafe(i + 1, j)) {
					a = mat[i + 1][j];
				}
				if (isSafe(i, j + 1)) {
					b = mat[i][j + 1];
				}
				if (isSafe(i + 1, j + 1)) {
					c = mat[i + 1][j + 1];
				}
				mat[i][j] += Math.max(a, Math.max(b, c));
				res = Math.max(mat[i][j], res);
			}
		}

		return res;

	}

	public static boolean isSafe(int i, int j) {
		if (i < 0 || i >= M || j < 0 || j >= N) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		int mat[][] = { { 500, 100, 230 }, 
						{ 1000, 300, 100 }, 
						{ 200, 1000, 200 } };

		M = mat.length;
		N = mat[0].length;
		System.out.println(maxPathSum(mat));

	}

}
