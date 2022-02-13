package com.example.keep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationNumber {
	
	 public static  List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> output = new ArrayList<List<Integer>>();
	        List<Integer> input = new ArrayList<Integer>();
	        int n = nums.length;
	        for(int i=0;i<n;i++){
	            input.add(nums[i]);
	        }
	        List<Integer> restOfList = new ArrayList<Integer>();
	        permuteUtil(input,restOfList,n,output);
	        return output;
	        
	    }
	    
	    public static void permuteUtil( List<Integer> input,  List<Integer> restOfList ,int n,  List<List<Integer>> output){
	        if(restOfList.size()==n){
	            output.add(new ArrayList<Integer>(restOfList));
	            return;
	        }
	        
	        for(int i =0;i<input.size();i++){
	           restOfList.add(input.get(i));
	           List<Integer> newInput = new ArrayList<Integer>();
	           for(int j=0;j<input.size();j++){
	               if(i!=j){
	                 newInput.add(input.get(j));  
	               }
	           }
	            permuteUtil(newInput,restOfList,n,output);
	            restOfList.remove(restOfList.size()-1);
	        }
	    }

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		permute(arr);

	}

}
