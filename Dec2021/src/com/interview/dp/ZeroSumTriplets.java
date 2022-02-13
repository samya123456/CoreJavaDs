package com.interview.dp;

import java.util.Arrays;

public class ZeroSumTriplets {

	public static void findZeroTriplet(int arr[]) {
		int n = arr.length;
		int i;
		int l;
		int r;
		Arrays.sort(arr);
		for (i = 0; i < n; i++) {
			 if(i>0 && arr[i-1]==arr[i]){
	                continue;
	            }
			l = i + 1;
			r = n - 1;
			int required_value = -arr[i];

			while (l < r) {
				int act_value = arr[l] + arr[r];
				if(act_value>required_value) {
					r--;
				}else if(act_value<required_value) {
					l++;
				}else {
					System.out.println(arr[i] +" "+arr[l]+" "+arr[r]);
					break;
				}
				
			}

		}

	}

	public static void main(String[] args) {

		int[] arr = {-1,0,1,2,-1,-4};
		findZeroTriplet(arr);
		

	}

}
