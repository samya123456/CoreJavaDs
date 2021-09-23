package com.example.dp;


import java.util.PriorityQueue;

public class KthLargestElement {
	
	
	static int kthLargestElement(int[] arr,int k) {
		PriorityQueue<Integer> minHeap =new PriorityQueue<Integer>();
		for(int i:arr) {
			minHeap.add(i);
			if(minHeap.size()>k) {
				minHeap.remove();
			}
		}
		
		return minHeap.remove();
	}

	public static void main(String[] args) {


	}

}
