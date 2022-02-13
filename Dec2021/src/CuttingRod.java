
public class CuttingRod {
	
	public static int rodMaxProfit(int[] len ,int[] price,int[][] dp ,int maxLen,int N ) {
		if(N==0 || maxLen==0) {
			return 0;
		}
		if(len[N-1]>maxLen) {
			dp[N][maxLen] = rodMaxProfit(len,price,dp,maxLen,N-1);
		}else {
			dp[N][maxLen] = Math.max(rodMaxProfit(len,price,dp,maxLen,N-1), price[N-1]+
					rodMaxProfit(len,price,dp,maxLen-len[N-1],N-1));
		}
		return dp[N][maxLen];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len[] = { 1, 2, 3, 4 };
		int price[] = { 1, 5, 8, 9 };
		int[][] dp = new int[price.length+1][price.length+1];
		System.out.println(rodMaxProfit(len,price,dp,price.length,price.length));

	}

}
