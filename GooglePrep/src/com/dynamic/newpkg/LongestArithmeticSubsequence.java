package com.dynamic.newpkg;

import java.util.HashMap;

public class LongestArithmeticSubsequence {

	public static int longestArithSeqLength(int[] nums) {

		if (nums.length <= 2) {
			return nums.length;
		}

		HashMap<Integer, Integer>[] dp = new HashMap[nums.length + 1];
		int ans = 1;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> currentMap = dp[i];
			for (int j = 0; j < i; j++) {

				int diff = nums[i] - nums[j];
				HashMap<Integer, Integer> prevMap = dp[j];
				int newVal = prevMap.getOrDefault(diff, 0) + 1;
				currentMap.put(diff, newVal);
				dp[i] = currentMap;
				ans = Math.max(ans, currentMap.get(diff));

			}
		}

		return ans + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 3, 6, 9, 12 };
		
		longestArithSeqLength(nums);

	}

}
