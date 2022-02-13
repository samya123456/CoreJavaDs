
public class NumberOfIsLand1 {
	
	public static int noOfIsLand(int[][] matrix) {
		int no_of_island =0;
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==1) {
					markIslands(matrix,i,j,matrix.length,matrix[0].length);
					no_of_island++;
				}
			}
		}
		
		return no_of_island;
	}

	private static void markIslands(int[][] matrix, int i, int j, int row, int column) {
		if(i<0 ||i>=row || j<0 || j>=column || matrix[i][j]!=1) {
			return ;
		}
		matrix[i][j] =2;
		markIslands(matrix,i+1,j,row,column);
		markIslands(matrix,i,j+1,row,column);
		markIslands(matrix,i-1,j,row,column);
		markIslands(matrix,i,j-1,row,column);
		
	}

	public static void main(String[] args) {
		int mat[][] =  {{1, 1, 0, 0, 0},
		                {0, 1, 0, 0, 1},
		                {1, 0, 0, 1, 1},
		                {0, 0, 0, 0, 0},
		                {1, 0, 1, 0, 1}};
		
		System.out.println(noOfIsLand(mat));

	}

}
