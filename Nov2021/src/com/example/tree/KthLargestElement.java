package com.example.tree;

import java.util.PriorityQueue;

public class KthLargestElement {
	
	
	public static int kThLargestElement(int[] arr,int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i:arr) {
			minHeap.add(i);
			if(minHeap.size()>k) {
				minHeap.remove();
			}
			
		}
		
		
		 System.out.println( minHeap.remove());
		 return -1;
	}

	public static void main(String[] args) {
		int[] arr= {1,5,3,2,4};
		kThLargestElement(arr,2);

	}

}
