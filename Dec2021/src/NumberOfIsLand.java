import java.util.Arrays;

public class NumberOfIsLand {
	
	static int countIsLand(int[][] mat) {
		int no_of_isLand = 0;
		int rows = mat.length;
		int cols = mat[0].length;
		int max =0;
		for(int i=0;i<rows;++i) {
			for(int j=0;j<cols;++j) {
				if(mat[i][j]==1) {
					int count =mark_dfs(mat,i,j,rows,cols,1);
					System.out.println("Count = "+count);
					if(count>max) {
						max=count;
					}
					
					no_of_isLand+=1;
				}
			}
		}
		
		return max;
	}

	private static int mark_dfs(int[][] mat, int i, int j, int rows, int cols,int count) {
		if(i<0 ||i>=rows || j<0 || j>= cols || mat[i][j]!=1) {
			return 0;
		}
		mat[i][j] =2;
		
		count+=mark_dfs(mat,i+1,j,rows,cols,count);
		count+=mark_dfs(mat,i,j+1,rows,cols,count);
		count+=mark_dfs(mat,i-1,j,rows,cols,count);
		count+=mark_dfs(mat,i,j-1,rows,cols,count);
		return count;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int mat[][] =  {{1, 1, 0, 0, 0},
		                {0, 1, 1, 1, 1},
		                {1, 1, 1, 1, 1},
		                {0, 0, 0, 0, 0},
		                {1, 0, 1, 0, 1}};
		
		countIsLand(mat);
		
		/* for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		} */
		

	}

}
