package com.example.dp;

import java.util.Stack;

public class ValidParentheses {
	
	public static boolean isValid(String str) {
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(!isopposite(ch)) {
				st.push(ch);
			}else {
				char temp = st.peek();
				if(returnOppositeParentheses(temp)==ch) {
					st.pop();
				}else {
					return false;
				}
			}
		}
		
		return st.isEmpty();
		
	}
	
	private static boolean isopposite(char ch) {
		if(ch ==')' || ch=='}' || ch==']') {
			return true;
		}
		return false;
	}
	
	private static Character returnOppositeParentheses(char ch) {
		if(ch =='(') {
			return ')';
		}else if(ch=='{') {
			return '}';
		}else if(ch=='[') {
			return ']' ;
		}
		else {
			return null;
		}
			
		
	}
		

	public static void main(String[] args) {

     System.out.println(isValid("(()){{}}{[}]"));

	}

}
