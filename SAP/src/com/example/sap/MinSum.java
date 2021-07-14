package com.example.sap;

public class MinSum {
	
	public static void solution(int n) {
		
		int i = 1;
		while(true) {
			if(getSum(n)*2 ==i) {
				System.out.println(i);
				break;
			}
			i++;
		}
		
	}
	
	public static int getSum(int n) {
		int sum =0;
		
		while(n!=0) {
			sum = sum + n%10;
			n =n/10;
		}
		return sum;
	}
	


	public static void main(String[] args) {
		solution(14);

	}

}
