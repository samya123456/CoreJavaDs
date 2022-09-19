package com.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
	
	 public  static List<Integer> majorityElement(int[] nums) {
		 int count1 = 0;
	        int count2 =0;
	        int element1 = Integer.MAX_VALUE;
	        int element2 = Integer.MAX_VALUE;
	        int n  = nums.length;
	        
	        for(int i =0;i<n;i++){
	            if(nums[i] == element1){
	                count1++;
	            }else if(nums[i] == element2){
	                count2++;
	            }else if(count1 ==0){
	                count1=1;
	                element1= nums[i];
	            }else if(count2 ==0){
	                count2 =1;
	                element2 = nums[i];
	            }else{
	                count1--;
	                count2--;
	            }
	        }
	        
	        count1 =0;
	        count2 =0;
	        
	        for(int i =0;i<n;i++){
	            if(nums[i] == element1){
	                count1++; 
	            }else if(nums[i] == element2){
	                count2++;
	            }
	        }
	        
	        List<Integer> majorityElements = new ArrayList<>();
	        
	        if(count1> (n/3)){
	            majorityElements.add(element1);
	        }
	        if(count2> (n/3)){
	            majorityElements.add(element2);
	        }
	        
	        return majorityElements;
	    }

	public static void main(String[] args) {
		int nums[] = {1,2};
		
		System.out.println(majorityElement(nums));

	}

}
