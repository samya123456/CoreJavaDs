package com.example.dp;

import java.util.Arrays;

public class LIS {
	
	
	public static int lis(int[] input) {
		
		int dp[] = new int[input.length];
		Arrays.fill(dp, 1);
		for(int i=1;i<input.length;i++) {
			for(int j=0;j<i;j++) {
				if(input[i]>input[j]
						&& dp[i]<=dp[j]) {
					dp[i] =1+dp[j];
				}
			}
		}
		
		return dp[input.length-1];
	}

	public static void main(String[] args) {
		
		int[] input = {50, 3, 10, 7, 40, 80};
		
		System.out.println(lis(input));  

	}

}
  