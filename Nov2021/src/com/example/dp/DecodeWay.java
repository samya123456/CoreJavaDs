package com.example.dp;

public class DecodeWay {
	
	public static int numberOfWays(String s) {
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1] = s.charAt(0)=='0'? 0:1;
		
		for(int i=2;i<=n;i++) {
			int oneDigit = Integer.valueOf(s.substring(i-1,i));
			int twoDigit = Integer.valueOf(s.substring(i-2,i));
			
			if(oneDigit>=1) {
				dp[i] +=dp[i-1];
			}
			if(twoDigit>9 && twoDigit<=26) {
				dp[i] +=dp[i-2];
			}
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numberOfWays("12"));

	}

}
