package com.example.keep;

public class PerfectSqrWithOutSqrt {
	
	public static boolean isPerfectSqr(int n) {
		for(int i=1;i*i<=n;i++) {
			if((n%i)==0 && (n/i)==i) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSqr(36));

	}

}
