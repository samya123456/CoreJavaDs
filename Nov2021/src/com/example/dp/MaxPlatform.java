package com.example.dp;

import java.util.Arrays;

public class MaxPlatform {
	
	public static int maxplatform(int[] arr,int dep[]) {
		
		int needed_platform=1;
		int max_platform=1;
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i=1;
		int j=0;
		
		while(j<dep.length && i<dep.length) {
			if(arr[i]<=dep[j]) {
				needed_platform++;
				i++;
				if(needed_platform>max_platform) {
					max_platform =needed_platform;
				}
			}else {
				j++;
				needed_platform--;
			}
			
			
			
		}
		
		return max_platform;
		
	}

	public static void main(String[] args) {
		
		int arr[] = {900,940,950,1100,1500,1800};
		int dep[] = {910,1120,1130,1200,1900,2000};
		System.out.println(maxplatform(arr,dep));
		

	}

}
