package com.example.dp;

import java.util.Arrays;

public class LIS {
	
	
	public static int lis(int[] arr) {
		int n = arr.length;
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]
						&& lis[i]<=lis[j]) {
					lis[i] = 1 +lis[j];
				}
			}
		}
		
		return lis[n-1];
	}

	public static void main(String[] args) {

		int[] arr = {50, 3, 10, 7, 40, 80};
		System.out.println(lis(arr));

	}

}
