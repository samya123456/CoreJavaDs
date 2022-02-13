package com.example.dp;

public class CuttingRod {
	
	public static int ubs(int[] len,int[] price, int maxLength,int N,int[][] dp) {
		if(N==0 || maxLength==0) {
			return 0;
		}
		
		if(len[N-1]>maxLength) {
			dp[N][maxLength] = ubs(len,price,maxLength,N-1,dp);
		}else {
			dp[N][maxLength] = Math.max(price[N-1]+ubs(len,price,maxLength-len[N-1],N,dp),
					ubs(len,price,maxLength,N-1,dp));
		}
		return dp[N][maxLength];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int len[] = { 1, 2, 3, 4 };
		int price[] = { 1, 5, 8, 9 };
		int maxLength = 4;
		int N=maxLength;
		int[][] dp = new int[maxLength+1][maxLength+1];
		System.out.println(ubs(len,price,maxLength,N,dp));

	}

}
