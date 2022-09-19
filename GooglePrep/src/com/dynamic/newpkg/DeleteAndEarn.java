package com.dynamic.newpkg;

import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {
	
	 public static int deleteAndEarn(int[] nums) {
	        
	        Map<Integer,Integer> countMap = new TreeMap<>();
	        
	        for(int i =0;i<nums.length;i++){
	          countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);  
	        }
	        
	        int n = countMap.size();
	        int newArr[] = new int[n];
	        int j=0;
	        
	        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
	               newArr[j++] = entry.getKey();
	        }
	        
	      
	        
	        int max1 =0;
	        int max2 =0;
	        for(int i =0;i<n;i++){
	            if(i>0 && newArr[i-1] +1 == newArr[i]){
	            	 int temp = max2;
	                 max2 = Math.max(newArr[i] * countMap.get(newArr[i]) +max1,max2);
	                 max1 =temp;
	            }else{
	                 int temp = max2;
	                 max2 = newArr[i] * countMap.get(newArr[i])+max2;
	                 max1=temp;
	            }
	           
	        }
	        
	        return max2;
	        
	        
	    }

	public static void main(String[] args) {
		int nums[] = {1,1,1,2,4,5,5,5,6};
		
		System.out.println(deleteAndEarn(nums));

	}

}
