package com.example.dp;

import java.util.Arrays;

public class AmazonTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,1,2,3,3,4,6};
		int n = arr.length;
		int i=0;
		int j =0;
		int[] temp = new int[n];
		
		for(i=0;i<n;i++) {
			if(arr[i]!=arr[i+1]) {
				temp[j++]=arr[i];
				temp[j++]=arr[n-1];
			}
		}
		
		for(i=0;i<=j;i++) {
			arr[i] =temp[i];
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));

	}

}
