package com.example.dp;

import java.util.LinkedHashMap;
import java.util.Map;

public class ZigZagConversion {
	
	
	public static String convert(String s ,int rownums) {
		StringBuffer br = new StringBuffer("");
		Map<Integer,StringBuffer> wordMap = new LinkedHashMap<Integer,StringBuffer>();
		boolean up=false;
		int rem =0;
		for(int i=0;i<s.length();i++) {
			if(rem==rownums) {
				up=true;
			}else if(rem==1) {
				up=false;
			}
			if(!up) {
				rem++;
			}else {
				rem--;
			}
			
			if(wordMap.containsKey(rem)) {
				wordMap.get(rem).append(s.charAt(i));
			}else {
				wordMap.put(rem, new StringBuffer().append(s.charAt(i)));
			}
			
		}
		
		for(Map.Entry<Integer,StringBuffer> entry: wordMap.entrySet()) {
			br.append(entry.getValue());
		}
		
		return br.toString();
		
		
	}

	public static void main(String[] args) {
		String s ="PAYPALISHIRING";
		//PAHNAPLSIIGYIR
		System.out.println(convert("PAYPALISHIRING",3));

	}

}
