package com.microsoft;

public class LongestHappyString {

	public static String longestDiverseString(int a, int b, int c) {
		
		StringBuffer output = new StringBuffer();
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		int total = a+b+c;
		for(int i=0;i<total;i++) {
			if((a>=b && a>=c && aCount!=2) ||(a>0 &&(bCount==2 || cCount==2))) {
				output.append('a');
				aCount++;
				bCount =0;
				cCount =0;
				a--;
			}
			else if((b>=a && b>=c && bCount!=2) ||(b>0 &&(aCount==2 || cCount==2))) {
				output.append('b');
				bCount++;
				aCount =0;
				cCount =0;
				b--;
			}
			else if((c>=b && c>=a && cCount!=2) ||(c>0 &&(aCount==2 ||  bCount==2))) {
				output.append('c');
				cCount++;
				bCount =0;
				aCount =0;
				c--;
			}
		}
		return output.toString();
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int c = 7;
		System.out.println(longestDiverseString(a,b,c));

	}

}
