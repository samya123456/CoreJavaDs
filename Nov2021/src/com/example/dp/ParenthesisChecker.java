package com.example.dp;

import java.util.Stack;

public class ParenthesisChecker {
	
	public static boolean isValid(String parenthesis) {
		
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<parenthesis.length();i++) {
			char ch = parenthesis.charAt(i);
			if(isClosingParemthesis(ch)) {
				char top = st.peek();
				if(ch!=closingParemthesis(top)) {
					return false;
				}else {
					st.pop();
					continue;
				}
			}else {
				st.push(ch);
			}
		}
		if (st.isEmpty()){
			return true;
		}else {
			return false;
		}
		
	}
	
	private static boolean isClosingParemthesis(char ch) {
		if(ch==')'||ch=='}'||ch==']') {
			return true;
		}
		return false;
	}
	
	private static char closingParemthesis(char ch) {
		if(ch=='(') {
			return ')';
		}else if(ch=='{') {
			return '}';
		}
		else if(ch=='[') {
			return ']';
		}
		else {
			return '0';
		}
	}
	
	

	public static void main(String[] args) {
		System.out.println(isValid("({[]})"));

	}

}
