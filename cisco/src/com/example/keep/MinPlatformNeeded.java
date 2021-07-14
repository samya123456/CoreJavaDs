package com.example.keep;

import java.util.Arrays;

public class MinPlatformNeeded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		System.out.println(minStationRequired(arr,dep));

	}

	private static int minStationRequired(int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1;
		int j = 0;
		int maxPlatForm =1;
		int neededPlatform =1;
		int n = arr.length;
		
		while(i<n && j<n) {
			if(arr[i]<=dep[j]) {
				neededPlatform ++;
				i++;
				if(maxPlatForm<neededPlatform) {
				  maxPlatForm = neededPlatform;
				}
			}else {
				neededPlatform--;
				j++;
			}
		}
		
		return maxPlatForm;
	}

}
