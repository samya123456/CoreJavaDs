package com.example.keep;

public class RodCutting {
	public static int maxProfit(int length[],int profit[]) {
		
		int[][] maxProfitArray = new int[length.length+1][length.length+1];
		return maxProfitUtil(maxProfitArray,length,profit,length.length,length.length);
	}

   private static int maxProfitUtil(int[][]maxProfitArray,int[] length, int[] profit, int maxLength, int N) {
		if(N==0||maxLength==0) {
			return 0;
		}
		if(length[N-1]>maxLength) {
			maxProfitArray[N][maxLength] = maxProfitUtil(maxProfitArray,length,profit,maxLength,N-1);
		}
		else {
			maxProfitArray[N][maxLength] = Math.max(profit[N-1]+maxProfitUtil(maxProfitArray,length,profit,maxLength-length[N-1],N)
			, maxProfitUtil(maxProfitArray,length,profit,maxLength,N-1));
		}
		
		return maxProfitArray[N][maxLength];
		
	} 

	public static void main(String[] args) {
		int[] length = {1,2,3,4};
		int[] price = {1,5,2,0};
		System.out.println(maxProfit(length,price));;

	}

}
