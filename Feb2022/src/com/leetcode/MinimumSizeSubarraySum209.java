package com.leetcode;

public class MinimumSizeSubarraySum209 {
	
	 public static int minSubArrayLen(int target, int[] nums) {
		 int left =0;
	        int min_len = Integer.MAX_VALUE;
	        int sum =0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            if(sum>=target){
	                 while(sum>=target){
	                sum -=nums[left++];
	            }
	              min_len = Math.min(min_len,(i-left+2));
	            }
	           
	        }
	        
	        return min_len ==Integer.MAX_VALUE ? 0 : min_len;
	        
	    }

	public static void main(String[] args) {
		int  target = 7;
		int nums[] = {2,3,1,2,4,3};
		
		minSubArrayLen(target,nums);

	}

}
