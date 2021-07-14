package payPal;

import java.util.Arrays;
import java.util.Collections;

public class LongestPalindromeSubstring {
	
	
	public static String longestPalindromeSubstring(String s) {
		if(s==null) return "";
		int start =0;
		int end =0;
		for(int i=0;i<s.length();i++) {
			int len1 = checkPalindromeFromMiddle(s,i,i);
			int len2 = checkPalindromeFromMiddle(s,i,i+1);
			int len = Math.max(len1,len2);
			
			if(len>(end-start)) {
				start = i-((len-1))/2 ;
				end =i+ (len/2);
			}
		}
		
		return s.substring(start,end+1);
	}
	private static int checkPalindromeFromMiddle(String s, int left ,int right) {
		
		if (s==null || left>right) return 0;
		
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		
		return right-left-1;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubstring("racecar"));
		
		

	}

}
