package com.example.dp;

public class CuttingRod {

	static int getMaxProfit(int[] length, int[] price, int maxLength) {
		int[][] maxLen = new int[length.length+1][length.length+1];
		return getMaxProfitUtil(length,price,maxLength,length.length,maxLen);

	}

	private static int getMaxProfitUtil(int[] length, int[] price, int maxLength, int N, int[][] maxLen) {
		
		if(N==0 || maxLength==0) {
			return 0;
		}
		
		if(length[N-1]>maxLength) {
			maxLen[N][maxLength] = getMaxProfitUtil(length,price,maxLength,N-1,maxLen);
		}else {
			maxLen[N][maxLength] = Math.max(price[N-1]+getMaxProfitUtil(length,price,maxLength-length[N-1],N,maxLen),
					getMaxProfitUtil(length,price,maxLength,N-1,maxLen));
		}
		return maxLen[N][maxLength];

	}

	public static void main(String[] args) {
		int len[] = { 1, 2, 3, 4 };
		int price[] = { 1, 5, 8, 9 };
		int maxLength = 4;
		System.out.println(getMaxProfit(len,price,maxLength));

	}

}
