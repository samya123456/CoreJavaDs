package com.example.dp;

public class MaxSumSubArray {
	
	public static int maxSumSubArray(int[] input) {
		int current_sum =input[0];
		int max_sum =current_sum;
		
		for(int i=1;i<input.length;i++) {
			current_sum = Math.max(input[i]+current_sum, input[i]);
			max_sum= Math.max(max_sum, current_sum);
		}
		
		return max_sum;
	}

	public static void main(String[] args) {
		
		int[] inputArray = {-2,2,5,-11,6};
		System.out.println(maxSumSubArray(inputArray));
	}

}
