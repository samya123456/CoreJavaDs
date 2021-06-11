package com.example.keep;

public class CuttingRod {
	
	 
	
	 public static int solve(int[] len, int[] price ,int maxLength) {
		 int[][] mcr = new int[len.length+1][len.length+1];
		return solveUtil(len,price,maxLength,len.length,mcr);
		 
	 }
	 
	 public static int solveUtil(int[] len, int[] price,int maxLength,int N, int[][] mcr) {
		 if(N==0 || maxLength==0) {
			 return 0;
		 }
		 
		 if(len[N-1]>maxLength) {
			 mcr[N][maxLength] = solveUtil(len, price,maxLength ,N-1, mcr);
		 }else {
			 mcr[N][maxLength] = Math.max(price[N-1]+ solveUtil(len, price,maxLength-len[N-1] ,N, mcr),
					 solveUtil(len, price,maxLength ,N-1, mcr));
		 }
		 
		 return mcr[N][maxLength];
		 
	 }
	 
	 
	 

	public static void main(String[] args) {
		int len[] = {1,2,3,4};
		int price[] = {1,5,8,9};
		int maxLength =4;
		System.out.println(solve(len,price,maxLength));;

	}

}
