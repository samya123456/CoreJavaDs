package com.ds;

public class HeapImpl {

	public void insert(int[] A, int n, int value) {
		n = n + 1;
		A[n] = value;

		int i = n;

		while (i > 1) {
			int parent = i / 2;
			if (A[i] > A[parent]) {
				swap(A, i, parent);
				i = parent;
			} else {
				return;
			}
		}
	}

	public void delete(int A[], int n) {

		A[1] = A[n];
		n = n - 1;
		int i = 1;

		while (i < n) {
			int left = A[i * 2];
			int right = A[i * 2 + 1];
			int larger = left > right ? i * 2 : i * 2 + 1;

			if (A[i] < A[larger]) {
				swap(A, i, larger);
				i = larger;
			} else {
				return;
			}
		}

	}

	public static void heapify(int[] A, int n, int i) {
		int largest = i;
		int l = 2 * i;
		int r = 2 * i + 1;

		if (l <= n && A[largest] < A[l]) {
			largest = l;
		}

		if (r <= n && A[largest] < A[r]) {
			largest = r;
		}
		
		if(largest!=i) {
			swap(A,i,largest);
			heapify(A,n,largest);
		}
	}
	
	public static void buildHeap(int[] A, int n) {
		for(int i=n/2 ;i>0;i--) {
			heapify(A,n,i);
		}
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}

	public static void main(String[] args) {

	}

}
