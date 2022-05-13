package com.example.dp;

import java.util.Arrays;

public class Arrange012 {
	
	public static void arrange (int[] arr) {
		int l =0;
		int m=0;
		int h = arr.length-1;
		
		while(m<=h) {
			
			
			if(arr[m]==0) {
				int temp = arr[m];
				arr[m] = arr[l];
				arr[l] = temp;
				m++;
				l++;
			}else if (arr[m]==1) {
				m++;
			}else if(arr[m]==2) {
				int temp = arr[m];
				arr[m] = arr[h];
				arr[h] = temp;
				h--;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {0,1,2,0,1,2};
		
		arrange(arr);
		System.out.println(Arrays.toString(arr));
		
		

	}

}
