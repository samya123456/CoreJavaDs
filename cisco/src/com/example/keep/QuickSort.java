package com.example.keep;

public class QuickSort {
	
	static void quickSort(int[] arr ,int low, int high) {
		
		int pi = partition(arr,low ,high);
		
		quickSort(arr,low,pi-1);
		quickSort(arr,pi+1,high);
		
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i =low-1;
		
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				
			}
		}
		
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
