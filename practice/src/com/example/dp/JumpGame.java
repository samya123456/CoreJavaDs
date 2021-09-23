package com.example.dp;

public class JumpGame {
	
	public boolean canJump(int arr[]) {
		int lastGoodIndex = arr.length-1;
		
		for(int i=arr.length-1 ;i>=0;i--) {
			if(i+arr[i]>=lastGoodIndex) {
				lastGoodIndex =i;
			}
		}
		return lastGoodIndex==0;
	}

	public static void main(String[] args) {



	}

}
