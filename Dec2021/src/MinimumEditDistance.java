
public class MinimumEditDistance {
	
	static int editDistDP(String str1, String str2, int m, int n) 
	{ 
		
		int dp [][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0) {
					dp[i][i] =j;
				}else if(j==0) {
					dp[i][j]=i;
				}else if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1+ Math.min(dp[i][j-1] // Insert 
							, Math.min(dp[i-1][j], //delete
									dp[i-1][j-1]));//update
					
				}
			}
		}
		return dp[m][n];
		
	}
	
	
	

	public static void main(String[] args) {
		String str1 = "sunday"; 
		String str2 = "saturday"; //minimum edit require to make sunday to saturday
		
		System.out.println(editDistDP(str1,str2,str1.length(),str2.length()));

	}

}
