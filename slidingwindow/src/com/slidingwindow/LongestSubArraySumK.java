package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {

	public static int longestSubArraySumK(int A[], int K) {
		
		    int sum =0;
	        int maxLength =0;
	        int j =0;
	        int N = A.length;
	        Map<Integer,Integer> map = new HashMap<>();
	        
	        while(j<N){
	            sum += A[j];
	            
	            if (sum ==K){
	                maxLength = j+1;
	            }
	            if(!map.containsKey(sum)){
	                map.put(sum,j);
	            }
	            if(map.containsKey(sum-K)){
	                int i = map.get(sum-K);
	                maxLength = Math.max(maxLength, j-i);
	            }
	            
	            j++;
	        }
	        
	        return maxLength;

		

	}

	public static void main(String[] args) {
		int arr[] = { -5, 8, -14, 2, 4, 12 };
		int k = -5;

		// o/p =5
		System.out.println(longestSubArraySumK(arr, k));

	}

}
