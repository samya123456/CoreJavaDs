package com.example.dp;

public class SpiralRotation2DArray {
	
	static void spiralRotation(int[][] input) {
		int n = input.length;
		int m = input[0].length;
		int top=0;
		int buttom =n-1;
		int left =0;
		int right =m-1;
		int dir =0;
		while(top<=buttom && left<=right) {
			if(dir==0) {
				for(int i=left;i<=right;i++) {
					System.out.print(input[top][i] +" ");
					
				}
				top++;
			}else if(dir==1){
				for(int i=top;i<=buttom;i++) {
					System.out.print(input[i][right] +" ");
					
				}
				right--;
				
			}else if(dir==2) {
				for(int i=right;i>=left;i--) {
					System.out.print(input[buttom][i] +" ");
					
				}
				buttom--;
			}else if(dir==3) {
				for(int i=buttom;i>=top;i--) {
					System.out.print(input[i][left] +" ");
					
				}
				left++;
			}
			dir = (dir+1)%4;
			
		}
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 },
			 	   { 5, 6, 7, 8 },
			 	   { 9, 10, 11, 12 },
			 	   { 13, 14, 15, 16 } };
		spiralRotation(a);

	}

}
