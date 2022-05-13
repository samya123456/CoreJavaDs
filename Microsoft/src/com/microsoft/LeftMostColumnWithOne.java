package com.microsoft;

public class LeftMostColumnWithOne {
	
	
	public static  int leftMostColumnWithOne(int[][] binaryMatrix) {
        
        int row = binaryMatrix.length;
        int col = binaryMatrix[0].length;
       
            
        int n = 0;
        int m = col-1;
        
        while(n<row && m>=0) {
        	if(binaryMatrix[n][m] ==1) {
        		m--;
        	}else {
        		n++;
        	}
        }
        
        return m == (col-1) ? -1 :m+1;
        
       
    }

	public static void main(String[] args) {
		int[][] binaryMatrix ={{0,0,0,1},
		                       {0,0,1,1},
		                       {0,1,1,1}};
		System.out.println(leftMostColumnWithOne(binaryMatrix));

	}

}
