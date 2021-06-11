package com.example.keep;

import java.util.*;

public class GenerateParenthesis {
	
	public static  List<String> generateParenthesis(int n) {
		List<String> op = new ArrayList<String>();
		generateParenthesisUtil(op,"",0,0,n);
		return op;
	}
	

	private static void generateParenthesisUtil(List<String> op, String current_string, int open, int close, int max) {
		if(current_string.length()==max*2) {
			op.add(current_string);
			return;
		}
		
		if(open<max) generateParenthesisUtil(op,current_string+"(",open+1,close,max);
		if(close<open) generateParenthesisUtil(op,current_string+")",open,close+1,max);
		
	}


	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));

	}

}
