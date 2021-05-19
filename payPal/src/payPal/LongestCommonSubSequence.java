package payPal;

public class LongestCommonSubSequence {
	
	public static int lcs(String a,String b) {
		int n = a.length();
		int m =b.length();
		
		int[][] lcs = new int[n+1][m+1];
		int i=0;
		int j=0;
		for( i=0;i<=n;i++) {
			for( j=0;j<=m;j++) {
				if(i==0 || j==0) {
					lcs[i][j] =0;
				}else if (a.charAt(i-1)==b.charAt(j-1)){
					lcs[i][j] = 1+lcs[i-1][j-1];
					
				}else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
					
			}
		}
		
		return lcs[n][m];
	}

	public static void main(String[] args) {
		String a ="ABCDGH";
		String b = "AEDFHR";
		System.out.println(lcs(a,b));
		

	}

}
