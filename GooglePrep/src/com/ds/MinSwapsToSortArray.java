package com.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwapsToSortArray {
	
	public static int minSwapsToSortArray(int arr[]) {
		int ans =0;
		
		Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++) {
			indexMap.put(arr[i], i);
		}
		
		Arrays.sort(arr);
		boolean visited[] = new boolean[arr.length];
		for(int i =0;i<arr.length;i++) {
			if(visited[i] || indexMap.get(arr[i])==i) {
				continue;
			}
			
			int swaps =0;
			int j =i;
			
			while(!visited[j]) {
				visited[j] =true;
				j = indexMap.get(arr[i]);
				swaps++;
			}
			if(swaps>0) {
				ans += (swaps-1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4, 3, 2, 1};
		System.out.println(minSwapsToSortArray(arr));

	}

}
