package com.leetcode;

public class MaximumProductSubarray152 {
	
	 public static int maxProduct(int[] nums) {
		 int max = Integer.MIN_VALUE;
		 
		 for(int n:nums) {
			 max = Math.max(max, n);
		 }
		 int res =max;
		 int curr_max =1;
		 int curr_min =1;
		 
		 for(int i=0;i<nums.length;i++) {
			 if(nums[i]==0) {
				 curr_max =1; 
				 curr_min =1;
			 }else {
				int temp= curr_max ;
				curr_max = Math.max(nums[i]*curr_max,Math.max( nums[i]*curr_min, nums[i]));
				curr_min = Math.min(nums[i]*temp,Math.min( nums[i]*curr_min, nums[i]));
				res = Math.max(curr_max,Math.max(curr_min,res));
			 }
		 }
		 return res;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,3,-2,4};
		System.out.println(maxProduct(nums));

	}

}
