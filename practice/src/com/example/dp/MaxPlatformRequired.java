package com.example.dp;

import java.util.Arrays;

public class MaxPlatformRequired {
	
	public static int maxPlatformRequired(int[] arr,int[] dep) {
		int i=1;
		int j=0;
		int max_platform =1;
		int req_platform =1;
		int n = arr.length;
		Arrays.sort(arr);
		Arrays.sort(dep);
		while(i<n && j<n) {
			if(arr[i]<dep[j]) {
				i++;
				req_platform++;
				if(max_platform<req_platform) {
					max_platform=req_platform;
				}
			}else {
				req_platform--;
				j++;
			}
		}
		
		return max_platform;
	}

	public static void main(String[] args) {
		
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		System.out.println(maxPlatformRequired(arr,dep));


	}

}
