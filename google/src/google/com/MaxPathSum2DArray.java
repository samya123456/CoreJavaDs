package google.com;

public class MaxPathSum2DArray {
	
	public static int N = 3, M = 3;
	 static int findMaxPath(int mat[][])
	    {
	        
	       
			
		 int res = -1;
	        for (int i = 1; i < N; i++)
	        {
	            res = -1;
	            for (int j = 0; j < M; j++)
	            {
	                // When all paths are possible
	                if (j > 0 && j < M - 1)
	                    mat[i][j] += Math.max(mat[i - 1][j],
	                    		Math.max(mat[i - 1][j - 1],
	                                    mat[i - 1][j + 1]));
	 
	                // When diagonal right is not possible
	                else if (j > 0)
	                    mat[i][j] += Math.max(mat[i - 1][j],
	                                    mat[i - 1][j - 1]);
	 
	                // When diagonal left is not possible
	                else if (j < M - 1)
	                    mat[i][j] += Math.max(mat[i - 1][j],
	                                mat[i - 1][j + 1]);
	 
	                // Store max path sum
	                res = Math.max(mat[i][j], res);
	            }
	        }
	        return res;
	    }

	public static void main(String[] args) {
		  int mat[][] =  {{1 ,2 ,3},
		                  {9 ,8 ,7},
		                  {4 ,5 ,6}};
              

		  	System.out.println(findMaxPath(mat));

	}

}
