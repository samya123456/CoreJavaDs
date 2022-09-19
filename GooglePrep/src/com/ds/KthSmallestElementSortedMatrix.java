package com.ds;

public class KthSmallestElementSortedMatrix {
	
	public static int KthSmallestElement(int[][] matrix,int k) {
		int n = matrix.length;
		int m = matrix[0].length ;
		
		int startVal = matrix[0][0];
		int endVal = matrix[n-1][m-1];
		int midVal;
		
		while(startVal <= endVal) {
			
			 midVal = (startVal + endVal)/2;
			int ans=0;
			for(int i =0;i<n;i++) {
				int l =0;
				int h = m-1;
				int mid ;
				
				while(l<=h) {
					mid  = l + (h-l)/2;
					if(matrix[i][mid] <= midVal) {
						l = mid+1;
					}else {
						h = mid -1;
					}
				}
				ans +=l;
			}
			
			if(ans < k) {
				startVal = midVal +1;
			}else {
				endVal = midVal -1;
			}
		}
		
		return startVal;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,5,9},
						  {10,11,13},
						  {12,13,15}};
				int k = 8;
				
				System.out.println(KthSmallestElement(matrix,k));

	}

}
