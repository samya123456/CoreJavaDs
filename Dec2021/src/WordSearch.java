
public class WordSearch {
	
	  public static boolean exist(char[][] board, String word) {
	        int M =board.length;
	        int N =board[0].length;
	       
	      //  boolean visited[][] = new boolean[M][N];
	        for(int i=0;i<M;i++){
	            for(int j=0;j<N;j++){
	                if(board[i][j]==word.charAt(0)){
	                    return dfs(board,i,j,M,N,word,0);
	                }
	            }
	        }
	        return false;
	    }
	    
	    public static boolean dfs(char[][] board,int i,int j,int M,int N,String word,int index){
	        if(i<0 || i>=M ||j<0 ||j>=N ||index>= word.length()||board[i][j]!= word.charAt(index)){
	            return false;
	        }
	        if(index==word.length()-1) {
	        	return true;
	        }
	        index++;
	       
	      return  dfs(board,i+1,j,M,N,word,index)||
	        dfs(board,i-1,j,M,N,word,index)||
	        dfs(board,i,j+1,M,N,word,index)||
	        dfs(board,i,j-1,M,N,word,index);
	        
	       
	    }

	public static void main(String[] args) {
		char board[][]={{'A','B','C','E'},
						{'S','F','C','S'}
					   ,{'A','D','E','E'}};
		String word="SEE";
		System.out.println(exist(board,word));

	}

}
