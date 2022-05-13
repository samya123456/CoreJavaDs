package com.ds;

public class MajorityElement {
	
	public int majorityElement(int[] nums) {
        int count =1;
        int major =nums[0];
        
        for(int i =1;i<nums.length;i++){
            if(major!=nums[i]){
                count--;
            }else{
                count++;
            }
            
            if(count==0){
                major=nums[i];
                count=1;
            }
        }
        
        return major;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
