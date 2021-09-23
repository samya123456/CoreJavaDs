package com.example.dp;



import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class ZigZagConversion {
	
	public static String zigZagConversion(String s ,int numRows) {
		Map<Integer,String> charMap = new TreeMap<>();
		int rem =1;
		boolean down =true;
		
		for(int i=0;i<s.length();i++) {

			
			
			if(charMap.containsKey(rem)) {
				String temp = charMap.get(rem);
				charMap.put(rem, temp+s.charAt(i));
			}else {
				Character ch =  s.charAt(i);
				charMap.put(rem, ch.toString());
			}
			
			if(down) {
				rem++;
			}else {
				rem--;
			}
			if(rem==numRows) {
				down =false;
			}else if(rem==1) {
				down=true;
			}
			
			
		}
		
		StringBuffer br = new StringBuffer("");
		for(Entry<Integer, String> entry: charMap.entrySet() ) {
			br.append(entry.getValue());
		}
		
		return br.toString();
	}
	

	public static void main(String[] args) {
        //PAYPALISHIRING == PAHNAPLSIIGYIR
		/*P   A   H   N
		  A P L S I I G
		  Y   I   R*/
		
		System.out.println(zigZagConversion("PAYPALISHIRING",3));

	}

}
