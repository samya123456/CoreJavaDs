package com.microsoft;

import java.util.Stack;

public class RemoveKDigitsMinimum {
	
	  public static String removeKdigits(String num, int k) {
	        
	        Stack<Character> stack = new Stack<>();
	        stack.push(num.charAt(0));
	        
	        for(int i=1;i<num.length();i++){
	            
	                int top = stack.peek() -'0';
	                int curr_num = num.charAt(i) -'0';
	                if(top>curr_num && k>0){
	                    stack.pop();
	                    k--;

	                }
	                if(stack.isEmpty() && curr_num!=0) {
	                	stack.push(num.charAt(i));
	                }else if(!stack.isEmpty()) {
	                	stack.push(num.charAt(i));
	                }
	                 
	        }
	        
	        if(stack.isEmpty()){
	            return "0";
	        }
	        
	        StringBuffer br = new StringBuffer();
	        
	        for(int i=0;i<stack.size();i++) {
	        	br.append(stack.get(i));
	        }
	        return br.toString();
	    }

	public static void main(String[] args) {
		String nums ="10200";
		
		System.out.println(removeKdigits(nums,3));
		
		
		

	}

}
