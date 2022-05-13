package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	    public static  List<List<Integer>> threeSum(int[] nums) {
	    	
	    		Arrays.sort(nums);
	    		List<List<Integer>> output = new ArrayList<List<Integer>>();
	    		
	    		for(int i=0;i<nums.length-2;i++) {
	    			int sum = -nums[i];
	    			int left =i+1;
	    			int right = nums.length-1;
	    			while(left<right) {
	    				if(nums[left] + nums[right] ==sum) {
	    					List<Integer> temp = new ArrayList<Integer>();
	    					temp.add(nums[i]);
	    					temp.add(nums[left]);
	    					temp.add(nums[right]);
	    					if(!output.contains(temp)) {
	    						output.add(temp);
	    					}
	    					left++;
	    					right--;
	    				}else if(nums[left] + nums[right] >sum) {
	    					right--;
	    				}else {
	    					left++;
	    				}
	    			}
	    		}
	    		
	    		return output;
	        
	    }

	public static void main(String[] args) {
		//Input: nums = [-1,0,1,2,-1,-4]
		//Output: [[-1,-1,2],[-1,0,1]]
		int[] nums = {-1,0,1,2,-1,-4};
		
		System.out.println(threeSum(nums));
	

	}

}
