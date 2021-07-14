package com.example.sap;

import java.util.Arrays;

public class CoinChange {
	
	public static int getMinNoOfCoins(int coins[],int amount) {
		int dp[] = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		
		for(int i=0;i<=amount;i++) {
			for(int j=0;j<coins.length;j++) {
				if(coins[j]<=i) {
					dp[i] = Math.min(coins[j], 1+ dp[i-coins[j]]);
				}
			}
		}
		
		return dp[amount]>amount? -1:dp[amount] ;
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3};
       
		System.out.println(getMinNoOfCoins(arr,6));

	}

}
