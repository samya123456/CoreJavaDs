package com.example.keep;

public class LongestPalindromeSubString {
	
	public static String longestPalindromeSubString(String input) {
		int start =0;
		int end =0;
		for(int i=0;i<input.length();i++) {
			int len1 = palindromeSubStringLength(input,i,i);
			int len2 = palindromeSubStringLength(input,i,i+1);
			int len = Math.max(len1, len2);
			
			if(len>(end-start)) {
				end = i +(len/2);
				start = i - ((len-1)/2);
			}
		}
		return input.substring(start,end+1);
		
	}
	
	public static int palindromeSubStringLength(String input, int left,int right) {
		if(input==null || input.equals(""))
			return 0;
		while(left>=0 && right<input.length() && input.charAt(left)==input.charAt(right)) {
			left--;
			right++;
		}
		
		return right -left -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Input: Given string :"forgeeksskeegfor", 
		//Output: "geeksskeeg"
		System.out.println(longestPalindromeSubString("forgeeksskeegfor"));

	}

}
