package com.example.dp;

public class LongestPalindromeSubstring {
	
	public static String longestPalindromeSubstring(String input) {
		
		int start=0;
		int end =0;
		
		for(int i=0;i<input.length();i++) {
			int len1 = expandFromMiddle(input,i,i);
			int len2 = expandFromMiddle(input,i,i+1);
			int len = Math.max(len1, len2);
			
			if(len>(end-start)) {
				start = i -((len-1)/2);
				end = i+ (len/2);
			}
		}
		
		return input.substring(start,end+1);
		
		
	}
	
	
	private static int expandFromMiddle(String input,int left,int right) {
		if(input==null || left>right) return 0;
		
		while(left>=0 && right <input.length() && input.charAt(left)
				==input.charAt(right)) {
			left--;
			right++;
		}
		return right-left-1;
	}
	

	public static void main(String[] args) {
		
		System.out.println(longestPalindromeSubstring("babad"));
		
	}

}
