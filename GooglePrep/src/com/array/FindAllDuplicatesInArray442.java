package com.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray442 {
	
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> output_list = new ArrayList<>();
        
        for(int i =0;i<nums.length;i++){
            
            int index = Math.abs(nums[i]) -1;
            
            if(nums[index] <0) {
                output_list.add(index+1);
            }else{
                nums[index] = -nums[index];
            }
            
        }
        
        return output_list;
        
        
        
    }

	public static void main(String[] args) {
		int nums[] = {4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(nums));

	}

}
