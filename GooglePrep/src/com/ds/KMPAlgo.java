package com.ds;

public class KMPAlgo {
	
	
	public static void kmpAlgo(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int lps[]  = new int[m];
		constructLPSArray(pattern,m,lps);
		
		int i=0;
		int j=0;
		
		while(i<n) {
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}else {
				if(j!=0) {
					j = lps[j-1];
				}else {
					i++;
				}
				
			}
			
			if(j==m-1) {
				System.out.println("patter found index =" +(i-j));
				j = lps[j-1];
			}
			
		}
	}

	private static void constructLPSArray(String pattern, int m,int[] lps) {
		int j=1;
		int count =0;
		lps[0] =0;
		
		while(j<m) {
			if(pattern.charAt(j) == pattern.charAt(count)) {
				lps[j] = count+1;
				count++;
				j++;
			}else {
				if(count!=0) {
					count = lps[count-1];
				}else {
					lps[j]= 0;
					j++;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		String txt =  "AABAACAADAABAABA";
		 String pat =  "AABA";
		 kmpAlgo(txt,pat);

	}

}
