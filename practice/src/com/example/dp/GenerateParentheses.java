package com.example.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static List<String> generateParentheses(int num) {
		
		List<String> op = new ArrayList<String>();
		backTrack(op,"",0,0,num);
		return op;
	}
	
	private static void backTrack(List<String> op,String output_string,int open,int close,int max) {
		if(output_string.length()==max*2) {
			op.add(output_string);
			return;
		}
		if(open<max)backTrack(op,output_string+"(",open+1,close,max);
		if(close<open)backTrack(op,output_string+")",open,close+1,max);
	}

	public static void main(String[] args) {
		
		System.out.println(generateParentheses(3));


	}

}
