package com.example.sap;

import java.util.PriorityQueue;

public class KthLagrestElement {

	public static int findKthLagrestElement(int nums[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i : nums) {
			minHeap.add(i);

			if (minHeap.size() > k) {
				minHeap.remove();
			}

		}

		return minHeap.remove();
	}

	public static void main(String[] args) {
		int nums[] = { 10, 3, 7, 5, 20 };
		System.out.println(findKthLagrestElement(nums, 2));

	}

}
