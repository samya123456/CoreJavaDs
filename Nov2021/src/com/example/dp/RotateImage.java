package com.example.dp;

public class RotateImage {
	
	private static int[][] rotateimage(int[][] image){
		int n = image.length;
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
				//swap
			}
		}
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<(n/2);j++) {
				int temp = image[i][n-1-j];
				image[i][n-1-j] = image [i][j];
				image [i][j] = temp;
			}
		}
		
		return image;
	}

	public static void main(String[] args) {
		int matrix[][] = {  { 1, 2, 3 }, 
							{ 4, 5, 6 }, 
							{ 7, 8, 9 } };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println("-----------------------------");
		matrix = rotateimage(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();
		}

	}

}
