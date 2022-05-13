package com.ds;

public class RotateArray {
	
	
	public static void rotateArray(int[] arr,int k) {
		k %= arr.length;
		
		reverseArray(arr,0,arr.length-1);
		reverseArray(arr,0,k-1);
		reverseArray(arr,k,arr.length-1);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	}

	public static void main(String[] args) {



	}

}
