package com.microsoft;

public class KMPAlgo {
	
	
	public static void kmpAlgo(String txt ,String pattern) {
		
		int n = txt.length();
		int m = pattern.length();
		int lps[] = new int[m];
		constructLps(pattern,m,lps);
		int i =0;
		int j =0;
		while(i<n) {
			if(txt.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}else {
				if(j>0) {
					j = lps[j-1];
				}else {
					i++;
				}
			}
			
			if(j == m) {
				System.out.println("pattern found in " + (i-j));
				j = lps[j-1];
			}
		}
	}

	private static void constructLps(String pattern, int m, int[] lps) {
		int count =0;
		int i =1;
		lps[0] =0;
		
		while(i<m) {
			if(pattern.charAt(i) == pattern.charAt(count)) {
				lps[i] = ++count;
				i++;
			}else {
				if(count >0) {
					count = lps[count-1];
				}else {
					lps[i] =0;
					i++;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		 String txt=  "AABAACAADAABAABA";
         String pat=  "AABA";
         
         kmpAlgo(txt,pat);

	}

}
