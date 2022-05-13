package com.microsoft;

public class GridSearch {
	

    public static  boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    
                   if(dfs(i,j,n,m,board, visited,0, word)){
                       return true;
                   }else {
                	   visited = new boolean[n][m];
                   }
                }
            }
        }
        
        return false;
        
    }
    
    private static boolean dfs(int i,int j, int n,int m,char[][] board, boolean[][] visited, int index,String word){
        if(i>=n || i<0 || j>=m || j<0 || index >= word.length() || board[i][j] !=word.charAt(index) || visited[i][j]){
            return false;
        }
        if(index ==word.length()-1){
            return true;
        }
        visited[i][j] =true;
        index = index+1;
        return dfs(i+1,j,n,m,board, visited,index, word) ||
               dfs(i-1,j,n,m,board, visited,index, word) ||
               dfs(i,j+1,n,m,board, visited,index, word) ||
               dfs(i,j-1,n,m,board, visited,index, word);
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			char[][] board = {{'C','A','A'},
							  {'A','A','A'},
							  {'B','C','D'}};
							  
					String word ="AAB";
					System.out.println(exist(board,word));
	}

}
