package com.leetcode;

public class FactorialTrailingZeroes172 {
	
	public static int trailingZeroes(int n) {
		if(n<=4) return 0;
        int count=0;
        while(n>1){
        	int temp =n;
        	while(temp%5==0) {
        		count++;
        		temp=temp/5;
        	}
            n = n-1;
        }
        
       
        
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(trailingZeroes(10));

	}

}
