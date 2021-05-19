package com.leetcode.example;

import java.util.*;

public class MaxSumSubArray {

	
public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int maxSum = nums[0];
        int currSum =maxSum;
        for(int i=1;i<n;i++) {
        	currSum = Math.max(nums[i], currSum+nums[i]);
        	maxSum = Math.max(currSum, maxSum);
        	
        	/*
        	int tempSum = maxSum +nums[i];
        	if(tempSum>maxSum && tempSum>nums[i]) {
        		maxSum =tempSum;
        		endIndex =i;
        	}else if(tempSum>maxSum && tempSum<nums[i]) {
        		maxSum = nums[i];
        		startIndex =i;
        		endIndex =i;
        	}else if(tempSum>maxSum) {
        		maxSum =tempSum;
        		endIndex =i;
        	}*/
        }
        
       
       
        
        return maxSum;
        
    }

public static int weightCapacity(List<Integer> weights, int maxCapacity) {
    // Write your code here
    Collections.sort(weights);
    
    List<Integer> al = new ArrayList<Integer>();
    int sum =0;
      for(int i= 0;i<weights.size();i++){
          sum = weights.get(i);
          for (int j=i+1;j<weights.size();j++){
              if(sum + weights.get(j) == maxCapacity) {
                  return maxCapacity;
              } else if(sum + weights.get(j)<maxCapacity){
                  al.add(sum + weights.get(j));
                  sum = sum + weights.get(j);
              }
          }
      }
      
      return Collections.max(al);
        
    }
	public static void main(String[] args) {
		
	
	}

}
