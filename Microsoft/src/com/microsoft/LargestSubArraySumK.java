package com.microsoft;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArraySumK {
	
	public int subarraySum(int[] nums, int k) {
		
		int count =0;
		Map<Integer ,Integer> map = new HashMap<Integer ,Integer>();
		map.put(0,1);
		int sum =0;
		
		for(int i =0;i<nums.length;i++) {
			sum += nums[i];
			
			if(map.containsKey(sum-k)) {
				count+= map.get(sum-k);
			}
			
			if(map.containsKey(sum)) {
				int temp = map.get(sum);
				map.put(sum,temp+1);
			}else {
				map.put(sum,1);
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
