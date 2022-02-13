
public class SetZeros {
	
	public static void setZeroes(int[][] matrix) {
        int N =matrix.length;
        int M =matrix[0].length;
        boolean visited[][] = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==0 && !visited[i][j]){
                	visited[i][j]=true;
                    for(int p =0;p<N;p++){
                    	if(matrix[p][j]!=0) {
                    		visited[p][j]=true;
                    	}
                        matrix[p][j]=0;
                        
                    }
                    for(int q =0;q<M;q++){
                    	if(matrix[i][q]!=0) {
                    		visited[i][q]=true;
                    	}
                        matrix[i][q]=0;
                        
                    }
                }
            }
        }
        
    }

	public static void main(String[] args) {
		int arr[][] =  {{0,1,2,0},
						{3,4,5,2},
						{1,3,1,5}};
		setZeroes(arr);

	}

}
