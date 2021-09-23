package com.example.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwap {
	
	
	
	public static int minSwaps(int arr[]) {
		int n = arr.length;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++) {
			map.put(arr[i], i);
		}
		
		Arrays.sort(arr);
		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);
		
		int ans =0;
		
		for(int i=0;i<n;i++) {
			
			if(visited[i] ||map.get(arr[i])==i) {
				continue;
			}
			
			int j =i ,cycle_size =0;
			while(!visited[j]) {
				visited[j]=true;
				
				j = map.get(arr[j]);
				cycle_size++;
			}
			
			if(cycle_size>0) {
				ans += (cycle_size-1);
			}
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int []a = {1, 5, 4, 3, 2};
		
		System.out.println(minSwaps(a));
		
		 

	}

}
