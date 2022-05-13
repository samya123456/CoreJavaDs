package com.microsoft;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {
	
	 public int[] maxSlidingWindow(int[] nums, int k) {
		 int n = nums.length;
		 int output[] = new int[n-k+1];
		 Deque<Integer> queue = new LinkedList<Integer>();
		 int l=0;
		 int i=0;
		 int r =0;
		 while(r<n) {
			 while(!queue.isEmpty() && nums[queue.peek()] < nums[r]) {
				 queue.pop();
			 }
			 queue.addLast(r);
			 
			 
			 if(l>queue.peek()) {
				 queue.pollFirst() ;
			 }
			 
			 if((r+1) >=k) {
				 output[i++] = nums[queue.peek()] ;
				 l++;
			 }
			 
			 r++;
			
		 }
		 
		 return output;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
