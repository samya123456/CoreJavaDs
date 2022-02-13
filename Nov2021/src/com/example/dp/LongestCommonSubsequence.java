package com.example.dp;

public class LongestCommonSubsequence {
	
	public static int lcs(String s1,String s2) {
		int n= s1.length();
		int m = s2.length();
		
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(i==0 ||j==0) {
					dp[i][j]=0;
				}else if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		 
		return  dp[n][m];
	}

	public static void main(String[] args) {
		String s1 ="ABCDEFG";
		String s2 ="AEDFHR";
		System.out.println(lcs(s1,s2));

	}

}
