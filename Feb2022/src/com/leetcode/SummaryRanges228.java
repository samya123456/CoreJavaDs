package com.leetcode;

import java.util.*;

public class SummaryRanges228 {

	public static List<String> summaryRanges(int[] nums) {
		List<String> output = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			int start =nums[i];
			
			while(i+1<nums.length && nums[i+1] ==nums[i]+1) {
				i++;
			}
			if(start!=nums[i]) {
				output.add(""+start+"->"+nums[i]);
			}else {
				output.add(""+start);
			}

		}

		return output;

	}

	public static void main(String[] args) {
		

		int nums[] = { 0, 1, 2, 4, 5, 7, 8 };
		System.out.println(summaryRanges(nums));

	}

}
