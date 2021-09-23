package com.example.dp;

public class MaxSumSubArray {
	
	
	public static int maxSum(int input[]) {
		int curr_sum = input[0];
		int max_sum = curr_sum;
		
		for(int i=1;i<input.length;i++) {
			curr_sum = Math.max( input[i], curr_sum+input[i]);
			max_sum = Math.max(max_sum, curr_sum);
		}
		
		return max_sum;
	}

	public static void main(String[] args) {
		
		int[] arr = {-2,2,5,-11,6};
		System.out.println(maxSum(arr));
		

	}

}
