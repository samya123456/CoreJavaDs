package com.example.dp;

public class FindCelebrity {
	
	static int[][] MATRIX =  { {0, 0, 1, 0},
	           {0, 0, 1, 0},
	           {0, 0, 0, 0},
	           {0, 0, 1, 0} };
	
	
	public static int findDelebrity(int n) {
		int celebrity =0;
		for(int i=0;i<n;i++) {
			if(MATRIX[celebrity][i]==1) {
				celebrity =i;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(i!=celebrity && MATRIX[celebrity][i]==1 && MATRIX[i][celebrity]==0) {
				return -1;
			}
		}
		return celebrity;
	}

	public static void main(String[] args) {
	
		System.out.println(findDelebrity(4));;
	}

}
