package com.example;

import java.util.ArrayList;

public class Test1 {
	
	String s ="abc";
	
	static ArrayList<String>  permutationSting(String input){
	  char[] arr = input.toCharArray();
	  ArrayList<String> list = new ArrayList<String>();
	  int per =permutation(arr.length);
	  
	  for(int i=0;i<per;i++) {
		  StringBuffer br = new StringBuffer();
		  int j=i;
		  int p=0;
		 while(p<arr.length) {
			  j= j%arr.length;
			  br.append(arr[j]) ;
			  j++;
			  
			  p++;
		  }
		  list.add(br.toString());
		  
	  }
	  
	  return list;
	  
	}
	
	static int permutation(int num) {
		int op =1;
		for(int i=num;i>1;i--) {
			op *=i;
		}
		
		return op;
	}

	public static void main(String[] args) {
		
		ArrayList<String > op = permutationSting("abc");
		
		for(String a: op) {
			System.out.println(a);
		}
	}

}
