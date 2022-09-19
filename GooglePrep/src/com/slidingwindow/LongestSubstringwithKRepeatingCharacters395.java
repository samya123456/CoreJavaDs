package com.slidingwindow;



public class LongestSubstringwithKRepeatingCharacters395 {
	
	public static int longestSubstring(String s, int k) {
		
		
		  int left  =0;
	      int right = 1;
	      char currentChar = s.charAt(0);
	      int count =1;
	      int max =0;
	      int totalCount =0;
	      while(right < s.length()){
	            
	            if(s.charAt(right) == currentChar){
	                count++;
	                right++;
	                
	            }else {
	                if(count >=k){
	                    
	                    totalCount += count;
	                    max = Math.max(totalCount,max);
	                }else{
	                    totalCount =0;
	                }
	                count =1;
	                left = right;
	                currentChar = s.charAt(left) ;
	                right++;
	            }
	        }
	        
	        return max;
	}

	public static void main(String[] args) {
		String s ="ababacb";
		int k =3;
		
		System.out.println(longestSubstring(s,k));

	}

}
