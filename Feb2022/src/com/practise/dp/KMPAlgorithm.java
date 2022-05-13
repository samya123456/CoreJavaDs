package com.practise.dp;

public class KMPAlgorithm {
	
	
	public static void searchPattern(String text,String pattern) {
		int N = text.length();
		int M = pattern.length();
		int i=0;
		int j=0;
		int[] lps = new int[M];
		createLPSAppay(pattern,M,lps);
		
		while(i<N) {
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}else if(j!=0){
				j =lps[j-1];
			}else {
				i++;
			}
			
			if(j==M-1) {
				System.out.println(i-j);
			}
			j =lps[j-1];
		}
	}

	private static void createLPSAppay(String pattern, int M, int[] lps) {
		
		int len=0;
		int i=1;
		lps[0] =0;
		while(i<M) {
			if(pattern.charAt(i)==pattern.charAt(len)) {
				lps[i] =len++;
				i++;
			}else if(len!=0) {
				len =lps[len-1];
				
			}else {
				lps[i] =0;
				i++;
			}
		}
		
		
	}

	public static void main(String[] args) {
		

	}

}
