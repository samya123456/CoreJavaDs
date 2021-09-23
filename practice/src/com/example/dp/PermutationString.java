package com.example.dp;

public class PermutationString {
	
	
	public static void permutationString(String input , String ros) {
		
		if(input.length()==0) {
			System.out.println(ros);
			return ;
		}
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			String newInput = input.substring(0,i) + input.substring(i+1);
			permutationString(newInput,ros+ch);
		}
	}

	public static void main(String[] args) {
		permutationString("abc","");


	}

}
