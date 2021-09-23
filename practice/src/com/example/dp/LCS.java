package com.example.dp;

public class LCS {
	
	public static int lcs(String s1, String s2) {
		int n= s1.length();
		int m = s2.length();
		int[][] lcs = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if (i==0 || j==0) {
					lcs[i][j] =0;
				}else if(s1.charAt(i-1)== s2.charAt(j-1)) {
					lcs[i][j] = 1+ lcs[i-1][j-1];
				}else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		return lcs[n][m];
	}

	public static void main(String[] args) {
		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	    
	    System.out.println(lcs(s1,s2));

	}

}
