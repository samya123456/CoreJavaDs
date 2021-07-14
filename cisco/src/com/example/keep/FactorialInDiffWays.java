package com.example.keep;

public class FactorialInDiffWays {
	
	public static int factDp(int n) {
		int[] dp = new int[n+1];
		dp[0] =1;
		dp[1] =1;
		for(int i=2;i<=n;i++) {
			dp[i] = i*dp[i-1];
		}
		return dp[n];
	}
	
	public static int factResursion(int n) {
		if(n<=1) {
			return 1; 
		}
		int temp = n * factResursion(n-1);
		return temp;
	}
	
	
	public static int factForLoop(int n) {
		if(n<=1) {
			return 1; 
		}
		int temp =1;
		for(int i=n;i>=1;i--) {
			temp = temp*i;
		}
		return temp;
	}

	public static void main(String[] args) {
		
		//System.out.println(factForLoop(4));

	}

}
