package com.example.dp;

import java.util.Arrays;

public class FibonacciSeries {
	
	
	public static int[] fibonacci(int n) {
		int[] arr = new int[n+1];
		arr[0] =0;
		arr[1] =1;
		for(int i=2;i<=n;i++) {
			arr[i] =arr[i-1]+arr[i-2];
		}
		return arr;
		
	}

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(fibonacci(9)));
	}

}
