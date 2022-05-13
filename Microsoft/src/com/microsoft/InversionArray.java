package com.microsoft;

import java.util.Arrays;

public class InversionArray {
	
	public static int mergeSort(int arr[] ,int l,int r) {
		int count =0;
		
		if(l<r) {
			int m = l + (r-l)/2 ;
			count +=mergeSort(arr,l,m);
			count +=mergeSort(arr,m+1,r);
			count +=sortedMerge(arr,l,m,r);
		}
		
		return count;
	}

	private static int sortedMerge(int[] arr, int l, int m, int r) {
		int[] left = Arrays.copyOfRange(arr, l, m+1);
		int[] right = Arrays.copyOfRange(arr, m+1, r+1);
		int i=0;
		int j=0;
		int k=l;
		int n = left.length;
		int p = right.length;
		int swaps =0;
		
		while(i<n && j<p) {
			if(left[i]<=right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
				swaps = (m+1) -(l+i);
			}
		}
		
		while(i<n) {
			arr[k++] = left[i++];
		}
		
		while(j<p) {
			arr[k++] = right[j++];
		}
		return swaps;
	}

	public static void main(String[] args) {
		
		 int[] arr = {8, 4, 2, 1};
		 System.out.println(mergeSort(arr,0,arr.length-1));

	}

}
