package com.dfs;

import java.util.Stack;

public class DecodeString394 {

	public static String decodeString(String s) {
		
		Stack<Integer> count = new Stack<>();
		Stack<String> result = new Stack<>();
		int index = 0;
		String res ="";
		
		while(index < s.length()) {
			
			if(Character.isDigit(s.charAt(index))) {
				
				int digit =0;
				
				while(Character.isDigit(s.charAt(index))) {
					digit = 10*digit + s.charAt(index) -'0';
					index++;
				}
				count.push(digit);
				
			}else if(s.charAt(index) == '[') {
				result.push(res);
				res ="";
				index++;
				
				
			}else if(s.charAt(index) == ']') {
				StringBuilder br = new StringBuilder(result.pop());
				int totalCount = count.pop();
				
				for(int i=0;i<totalCount;i++) {
					br.append(res);
				}
				res = br.toString();
				index++;
				
			}else {
				res += s.charAt(index++);
			}
		}
		
		return res;
		

	}

	public static void main(String[] args) {
		String s = "3[a2[c]]";
		// Output: "accaccacc"
		
		System.out.println(decodeString(s));

	}

}
