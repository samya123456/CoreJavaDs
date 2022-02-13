package com.example.dp;
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static List<String> generateParenthesis(int n){
		
		List<String> output_list = new ArrayList<String>();
		generateParenthesisUtil(output_list,"",0,0,n);
		return output_list;
		
	}

	private static void  generateParenthesisUtil(List<String> output_list, String gen_string, int open, int close, int max) {
		if(gen_string.length()==max*2) {
			output_list.add(gen_string);
			return ;
		}
		if(open<max)generateParenthesisUtil(output_list,gen_string+"(",open+1,close,max);
		if(close<open)generateParenthesisUtil(output_list,gen_string+")",open,close+1,max);
		
		
	}

	public static void main(String[] args) {
		
		List<String> op = generateParenthesis(3);
		System.out.println(op);
	}

}
