package com.example.keep;

public class CanJump {
	
	public static boolean canJump(int[] nums) {
		int lastGoodIndex = nums.length -1;
		
		for(int n= nums.length-1;n>=0;n--) {
			if(n+nums[n]>=lastGoodIndex) {
				lastGoodIndex =n;
			}
		}
		return lastGoodIndex==0;
	}

	public static void main(String[] args) {
		//Input: nums = [2,3,1,1,4]
		//Output: true
		int[] nums = {2,3,1,1,4};
		System.out.println(canJump(nums));
		

	}

}
