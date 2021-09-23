package com.example.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	static int longestSubstringWithoutRepeatingCharacters(String s) {
		Set<Character> set = new HashSet<>();
		
		int i=0;
		int j=0;
		int max=0;
		
		while(j<s.length()) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				max = Math.max(set.size(),max);
			}else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		
		return max;
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "pwwkew";//abcabcbb //pwwkew //bbbbb
		System.out.println(longestSubstringWithoutRepeatingCharacters(s));

	}

}
