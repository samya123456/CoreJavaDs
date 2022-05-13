package com.ds;

public class FindPeakElement {
	
	public static int findPeakElement(int arr[]) {
		int left =0;
		int right = arr.length;
		
		
		while(left<right) {
			int mid = left +(right-left)/2;
			
			if(arr[mid]<arr[mid+1]) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		
		return left;
	}

	public static void main(String[] args) {
		// [1,2,1,3,5,6,4]

	}

}
