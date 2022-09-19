package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class LibraryString {
	
	public static boolean isValid(String s, List<String> library) {
		
		
		int i =0;
		while(i<s.length()) {
			char ch = s.charAt(i);
			StringBuffer word = new StringBuffer();
			word.append(ch);
			boolean isvalid =false;
			if(library.contains(word.toString())) {
				isvalid =true;
				i++;
			}
			for(int j=i+1;j<s.length();j++) {
				word.append(s.charAt(j));
				if(library.contains(word.toString())) {
					isvalid =true;
					i =j+1;
				}
			}
			if(!isvalid) {
				return false;
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "cars";
		List<String> library = new ArrayList<String>();
		library.add("car");
		library.add("ca");
		library.add("rs");
		
		
		System.out.println(isValid(s,library));

	}

}
