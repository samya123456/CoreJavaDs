package com.example.dp;

public class RotateImage {
	
	public static int[][] rotateImage(int[][] input){
		 int N = input.length;
		 
		 for(int i=0;i<N;i++) {
			 for(int j=i;j<N;j++) {
				 int temp = input[i][j];
				 input[i][j]=input[j][i];
				 input[j][i] =temp;
			 }
		 }
		 
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<(N/2);j++) {
				 int temp = input[i][j];
				 input[i][j] = input[i][N-1-j];
				 input[i][N-1-j] = temp;
			 }
		 }
		 
		 return input;
	}

	public static void main(String[] args) {
		
		int[][] matrix = {{5,1,9,11},
						  {2,4,8,10},
						  {13,3,6,7},
						  {15,14,12,16}};

			int[][] op = rotateImage(matrix);
			
			 for(int i=0;i<op.length;i++) {
				 for(int j=0;j<op.length;j++) {
					 System.out.print(op[i][j]+" ");
					 
				 }
				 System.out.println();
			 }

	}

}
