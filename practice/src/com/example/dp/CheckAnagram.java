package com.example.dp;

import java.util.Arrays;

public class CheckAnagram {
	
	static boolean isAnagram(String a,String b) {
		if(a.length()!=b.length()) return false;
		char[] a_array = a.toCharArray();
		char[] b_array = b.toCharArray();
		
		Arrays.sort(a_array);
		Arrays.sort(b_array);
		
		if (new String(a_array).equals(new  String(b_array))) {
			return true;
		}
		
		
		
		return false;
	}
	
	static boolean isAnagram_2(String a,String b) {
		if(a.length()!=b.length()) return false;
		int[] num_array = new int[26];
		a = a.toLowerCase();
		b = b.toLowerCase();
		for(int i =0;i<a.length();i++) {
			num_array[a.charAt(i)-'a']++;
			num_array[b.charAt(i)-'a']--;
		}
		
		for(int i =0;i<26;i++) {
			if(num_array[i]!=0) {
				return false;
			}
		}
		
		return true;
	
	}

	public static void main(String[] args) {

		System.out.println(isAnagram_2("CAT", "CAR"));

	}

}
