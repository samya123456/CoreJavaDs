package com.example.keep;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

	public static void removeDuplicates(int[] nums) {
		int index =2;
		
		for(int i=2;i<nums.length;i++) {
			if(nums[i]!=nums[index-2]) {
				nums[index++]=nums[i];
			}
		}

	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3 };
		removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));

	}

}
