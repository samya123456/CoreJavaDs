package com.example.dp;

public class ContainerMostWater {
	
	public static int containerWithMostWater(int[] arr) {
		int max = Integer.MIN_VALUE;
		int j =arr.length-1;
		int i=0;
		
		while(i<j) {
			int min = Math.min(arr[i], arr[j]);
			max = Math.max(max, min * (j-i));
			
			if(arr[i]<arr[j]) {
				i++;
			}else {
				j--;
			}
		}
		return max;
		
	}

	public static void main(String[] args) {
		int [] arr = {1,8,6,2,5,4,8,3,7};
		
	System.out.println( containerWithMostWater(arr));	 ;
		
	}

}
