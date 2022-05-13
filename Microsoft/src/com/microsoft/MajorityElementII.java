package com.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
	
	 public  static List<Integer> majorityElement(int[] nums) {
	        Arrays.sort(nums);
	        float n = nums.length;
	        float m = n/3;
	        List<Integer> list = new ArrayList<>();
	        int major = nums[0];
	        int count = 0;
	        for(int i = 0;i<n;i++){
	        	if(count > m && !list.contains(major)) {
	                   list.add(major);
	                  
	                }
	            if(nums[i] == major){
	                count++;
	                
	            }else {
	               
	                   major = nums[i];
	                   count =1;
	            }
	        }
	        return list;
	    }

	public static void main(String[] args) {
		int nums[] = {1,2};
		
		System.out.println(majorityElement(nums));

	}

}
