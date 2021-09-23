package com.example.dp;

public class IslandProblem {
	
	static final int R = 5, C=5;
	static boolean isSafe(int[][]M , int row, int col, boolean[][] visited) {
		
		return (row>=0) && (row<R)  && (col>=0) && (col<C) && (M[row][col]==1 && !visited[row][col]);
			
	}
	
	static void  DFS(int[][]M , int row, int col, boolean[][] visited) {
		
		int rowNum[] = new int[] {-1,-1,-1,0,0,1,1,1};
		int colNum[] = new int[] {-1,0,1,-1,1,-1,0,1};
		
		visited[row][col] =true;
		
		for(int k=0;k<8;++k) {
			if(isSafe(M,row+rowNum[k],col+colNum[k],visited)){
				DFS(M,row+rowNum[k],col+colNum[k],visited);
			}
					
				
		}
	}
	
	
	static int countIsland(int M[][]) {
		
		
		boolean[][] visited = new boolean[R][C];
		int count =0;
		
		for(int i=0;i<R;++i) {
			for(int j=0;j<C;++j) {
				if(M[i][i]==1 && !visited[i][j]) {
					DFS(M,i,j,visited);
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int M[][] = new int[][] {   { 1, 1, 0, 0, 0 },
						             { 0, 1, 0, 0, 1 },
						             { 1, 0, 0, 1, 1 },
						             { 0, 0, 0, 0, 0 },
						             { 1, 0, 1, 0, 1 } };
						             
						             System.out.println(countIsland(M));

	}

}
