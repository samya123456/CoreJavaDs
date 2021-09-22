package com.example.keep;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArraySumZero {
	
	
	static int maxlenSumZero(int[] num) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int sum =0;
		int max_len =0;
		
		for(int i=0;i<num.length;i++) {
			sum +=num[i];
			if(num[i]==0 && max_len==0) {
				max_len =1;
			}
			if(sum==0) {
				max_len=i+1;
			}
			
			Integer prev_i = map.get(sum) ;
			if(prev_i!=null) {
				max_len = Math.max(max_len, i-prev_i);
			}else {
				map.put(sum, i);
			}
		}
		
		return max_len;
	}

	public static void main(String[] args) {
		
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		
		System.out.println(maxlenSumZero(arr));



	}

}
