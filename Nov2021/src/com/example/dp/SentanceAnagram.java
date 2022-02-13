package com.example.dp;

import java.util.Arrays;

public class SentanceAnagram {

	public static boolean checkAnagramSentance(String s1, String s2) {

		
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");
		if (s1.length() != s2.length()) {
			return false;
		}

		
		char[] chs1 = s1.toLowerCase().toCharArray();
		char[] chs2 = s2.toLowerCase().toCharArray();

		Arrays.sort(chs1);
		Arrays.sort(chs2);
		boolean status = Arrays.equals(chs1, chs2);

		return status;
	}

	public static void main(String[] args) {
		System.out.println(checkAnagramSentance("Mother In Law", "Hitler Woman"));

	}

}
