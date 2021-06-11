package com.example.keep;

import java.util.Arrays;

public class LIS {
	
	public static int lismethod(int[] arr) {
		int lis[] = new int[arr.length];
		Arrays.fill(lis, 1);
		
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] &&
						lis[i]<1+lis[j]) {
					lis[i] = 1+lis[j];
				}
			}
		}
		
		return lis[arr.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input: arr[] = {3, 10, 2, 1, 20}
		//Output: Length of LIS = 3
		int  arr[] = {3, 10, 2, 1, 20};
		System.out.println(lismethod(arr));

	}

}
