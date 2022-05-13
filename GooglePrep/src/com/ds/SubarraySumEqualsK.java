package com.ds;


import java.util.HashMap;
import java.util.Map;


public class SubarraySumEqualsK {
	
	  public static int subarraySum(int[] nums, int k) {
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        map.put(0,1);
	        int result =0;
	        int sum =0;
	        for(int i=0;i<nums.length;i++){
	            sum +=nums[i];
	            if(map.containsKey(sum-k)){
	                result +=map.get(sum-k);
	            }
	            if(map.containsKey(sum)){
	                int count = map.get(sum);
	                map.put(sum,count+1);
	            }else{
	                map.put(sum,1);
	            }
	        }
	        
	        return result;
	    }

	public static void main(String[] args) {
		int nums[] = {1,1,1};
		int k = 2;
		System.out.println(subarraySum(nums,k));
	}

}
