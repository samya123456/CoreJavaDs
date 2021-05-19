package google.com;

public class RotateImage {
	
	public void rotate(int[][] matrix) {
        int n= matrix.length;
        for(int i =0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp =  matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i =0;i<n;i++) {
        	for(int j=0 ;j<(n/2);j++) {
        		int temp =  matrix[i][j];
        		 matrix[i][j] = matrix[i][n-1-j];
        		 matrix[i][n-1-j] = temp;
        	}
        }
       
        
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
					//		0   1  2   3
		 int [][] matrix = {{5 ,1 ,9 ,11 },
				 			{2 ,4 ,8 ,10 },
				 			{13,3 ,6 ,7  },
				 			{15,14,12,16}};

	}

}
