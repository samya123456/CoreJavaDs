package com.ds;

public class MinimumWindowSubString {
	
	public static String minWindow(String s, String t) {
		if("".equals(s) || "".equals(t)) {
			return "";
		}
		
		String res ="";
		int[] letterCount = new int[128];
		int left =0;
		int count = 0;
		int minLength = Integer.MAX_VALUE;
		for(char c: t.toCharArray()) {
			++letterCount[c];
		}
		
		for(int right =0;right<s.length();++right) {
			if(--letterCount[s.charAt(right)]>=0) {
				++count;
			}
			
			while(count==t.length()) { 
				
				if(minLength>(right-left+1)) {
				   minLength=(right-left+1);
				   res = s.substring(left,right+1);
				}
				if(++letterCount[s.charAt(left)]>0) {
					   --count;
				 }
				++left;
			}
			
			
		}
		
		return res;
		
		
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

}
