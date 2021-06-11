package com.example.keep;

public class MaxSumSubArray {
	 public static int maxSumSubArray(int arr[]) {
		 int currSum =arr[0];
		 int maxSum = currSum;
		 
		 for(int i=1;i<arr.length;i++) {
			 currSum = Math.max(arr[i], currSum+arr[i]);
			 maxSum = Math.max(currSum, maxSum);
		 }
		 return maxSum;
	 }
	

	public static void main(String[] args) {
		int[] arr = {-2,2,5,-11,6};
		
		System.out.println(maxSumSubArray(arr));

	}

}
