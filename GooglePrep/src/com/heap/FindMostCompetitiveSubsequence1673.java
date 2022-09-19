package com.heap;

import java.util.Arrays;
import java.util.Stack;

public class FindMostCompetitiveSubsequence1673 {
	
	
public static int[] mostCompetitive(int[] nums, int k) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i =0;i<nums.length;i++){
            
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()] && stack.size() + nums.length -i >k){
                stack.pop();
            }
            
            if(stack.size() <k){
                stack.push(i);
            }
        }
        
        int[] ans = new int[k];
        int i =k;
        
        while(!stack.isEmpty()){
            ans[--i] = nums[stack.pop()];
        }
        return ans;
            
    }

	public static void main(String[] args) {
		int nums[] = {3,5,2,6};
		int k = 2;
		
		System.out.println(Arrays.toString(mostCompetitive(nums,k)));

	}

}
