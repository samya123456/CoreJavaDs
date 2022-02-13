package com.example.dp;

public class MSIS {
	
	public static int msis(int input[]) {
		int n = input.length;
		int[] dp = new int[n];
		for(int i=0;i<n;i++) {
			dp[i]=input[i];
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(input[i]>input[j]
						&& dp[i]<input[i]+dp[j]) {
					dp[i]=input[i]+dp[j];
				}
			}
		}
		
		
		int max = dp[0];
		for(int i=1;i<n;i++) {
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		
		 int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		System.out.println(msis(arr));

	}

}
