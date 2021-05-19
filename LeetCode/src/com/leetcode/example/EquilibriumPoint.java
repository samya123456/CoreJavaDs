package com.leetcode.example;

public class EquilibriumPoint {
	
	public int equiPoint(int arr[]) {
		int sum=0 ,leftSum=0 ,rightSum =0;
		int n =arr.length;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		
		for(int i =1;i<n;i++) {
			leftSum += arr[i-1];
			rightSum = sum - (leftSum +arr[i]);
			if(leftSum==rightSum) {
				return arr[i];
			}
		}
		return -1;
		
	}

	public static void main(String[] args) {
		int[] input = {1,2,6,4,0,-1};
		
	System.out.println(new EquilibriumPoint().equiPoint(input));

	}

}
