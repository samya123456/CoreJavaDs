package com.microsoft;

import java.util.Arrays;

public class FindWordsThatFormedCharacters {
	
	 public static int countCharacters(String[] words, String chars) {
	        
	        int[] charIndex = new int[26];
	        int output =0;
	        for(char c: chars.toCharArray()){
	            charIndex[c-'a']++;
	        }
	        
	        for(int i=0;i<words.length;i++){
	            int[] temp = Arrays.copyOf(charIndex,charIndex.length);
	            int charCount =0;
	            
	            for(char ch:words[i].toCharArray()){
	                if(temp[ch-'a']>0){
	                   charCount++;
	                   temp[ch-'a']--;
	                }
	            }
	            
	            if(charCount ==words[i].length()){
	                output += charCount;
	            }
	        }
	        
	        return output;
	    }

	public static void main(String[] args) {

		String[] words = {"cat","bt","hat","tree"};
		String chars = "atach";
		
		System.out.println(countCharacters(words,chars));

	}

}
