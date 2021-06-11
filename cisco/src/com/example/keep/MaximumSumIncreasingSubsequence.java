package com.example.keep;

public class MaximumSumIncreasingSubsequence {
	
	public static int maximumSumIncreasingSubsequence(int[] arr) {
		int msis[] = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			msis[i] = arr[i];
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] &&
						msis[i]<msis[j]+arr[i]) {
					msis[i] = msis[j]+arr[i];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<msis.length;i++) {
			if(max<msis[i]) {
				max= msis[i];
			}
		}
		return max;
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100)
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(maximumSumIncreasingSubsequence(arr));

	}

}
