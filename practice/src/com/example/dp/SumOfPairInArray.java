package com.example.dp;

import java.util.HashSet;
import java.util.Set;

public class SumOfPairInArray {

	static void printpairs(int arr[], int sum) {
		
		Set<Integer> st = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			int temp = sum - arr[i];
			
			if(st.contains(temp)) {
				System.out.println("Pair of " +arr[i] +" is "+ temp);
				return;
			}
			st.add(arr[i]);
		}

	}

	public static void main(String[] args) {
		 int A[] = { 1, 4, 45, 6, 10, 8 };
	        int n = 16;
	        printpairs(A, n);

	}

}
