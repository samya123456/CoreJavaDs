package com.example;

public class LongestPalindromeSubStr {
	
	 public static String LongestPalidromeSubstr(String input){
	        if(input==null || input.length()<1) return "";
	        int start = 0;
	        int end =0;
	        for(int i =0;i<input.length();i++){
	            int len1 = palindromeLength(input,i,i);
	            int len2 = palindromeLength(input,i,i+1);
	            int len = Math.max(len1,len2);
	            if(len>=(end-start)){
	                start = i- ((len-1)/2) ;
	                end = i+ (len/2) ;
	            }
	            
	          
	            
	        }
	          return input.substring(start,end+1);
	    }
	 
	 public  static int palindromeLength(String s, int left,int right){
	        if(s==null || left>right) return 0;
	        
	        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
	            left--;
	            right++;
	        }
	        
	        return right -left -1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestPalidromeSubstr("rfkqyuqfjkxy"));

	}

}
