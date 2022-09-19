package com.dynamic.newpkg;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public static boolean checkSubarraySum(int[] nums, int k) {

		Map<Integer, Integer> remMap = new HashMap<>();
		remMap.put(0, -1);

		int total = 0;

		for (int i = 0; i < nums.length; i++) {

			total += nums[i];
			int rem = total % k;

			if (!remMap.containsKey(rem)) {
				remMap.put(rem, i);

			} else if (i - remMap.get(rem) > 1) {
				return true;
			}

		}
		return false;

	}

	public static void main(String[] args) {
		int nums[] = {23,2,6,4,7};
		int k = 6;
		
		System.out.println(checkSubarraySum(nums,k));

	}

}
