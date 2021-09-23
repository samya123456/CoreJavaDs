package com.example.dp;

import java.util.ArrayList;
import java.util.List;

public class SplitArrFibonacciSeq {
	
	public static void splitInFibonacci(String s) {
		
		List<Integer> results = new ArrayList<Integer>();
		backTrack(s,results,0);
		System.out.println(results);
		
		
	}

	private static boolean backTrack(String s, List<Integer> results, int ind) {
		if(s.length()==ind) {
			return results.size()>2;
		}
		int num =0;
		for(int i=ind;i<s.length();i++) {
			num = num*10 + (s.charAt(i)-'0');
			if(results.size()<2 || results.get(results.size()-1) + results.get(results.size()-2)==num) {
				results.add(num);
				if(backTrack(s,results,i+1)) {
					return true;
				}
				results.remove(results.size()-1);
				
			}
			
			if(i==ind && s.charAt(i)=='0') {
				return false;
			}
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		
		splitInFibonacci("123456579");



	}

}
