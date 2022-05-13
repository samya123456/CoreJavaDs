package com.ds;

public class EncodeString {
	
	
	public static String encode(String input) {
		int left =0;
		int right =1;
		int count =1;
		StringBuffer br = new StringBuffer("");
		br.append(input.charAt(0));
		while(right<input.length()) {
			if(input.charAt(left) ==input.charAt(right)) {
				count++;
				right++;
			}else {
				br.append(count);
				count =1;
				br.append(input.charAt(right));
				left =right;
				right++;
			}
		}
		
		br.append(count);
		
		return br.toString();
	}

	public static void main(String[] args) {
		System.out.println(encode("aabbc"));

	}

}
