package payPal;

import java.util.*;

public class SplitArrayToFibonacciSeq {
	
	public static List<Integer> splitInFibonacci(String s){
		 List<Integer> result = new  ArrayList<Integer>();
		 backTrack(s,result,0);
		 return result;
		
	}

	private static boolean backTrack(String s, List<Integer> result, int ind) {
		
		if(s.length()==ind) {
			return result.size()>2;
		}
		int num =0;
		for(int i=ind ;i<s.length();i++) {
			num = num*10 + (s.charAt(i)-'0');
			
			if(result.size()<2 || result.get(result.size()-1) +result.get(result.size()-2)==num) {
				result.add(num);
				if(backTrack(s,result,i+1)) {
					return true;
				}
				result.remove(result.size()-1);
			}
			if(i==ind && s.charAt(i)=='0')
				return false;
		}
		
		return false;
		
		
	}

	public static void main(String[] args) {
		splitInFibonacci("123456579");

	}

}
