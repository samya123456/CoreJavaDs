package com.ds;

public class HeapImplementations {
	
	public void insert(int A[],int n,int value) {
		n = n+1;
		A[n] =value;
		
		int i =n;
		
		while(i>1) {
			int parent = i/2;
			
			if(A[i] >A[parent]) {
				swap(A,i,parent);
				i=parent;
			}else {
				return;
			}
			
		}
	}
	
	public void delete(int[] A,int n) {
		A[1] =A[n];
		n =n-1;
		
		int i=1;
		
		while(i<n) {
			int left = 2*i;
			int right = 2*i+1;
			int largest = A[left]>A[right] ?left:right;
			
			if(A[largest]>A[i]) {
				swap(A,largest,i);
				i =largest;
			}else {
				return;
			}
		}
	}

	private void swap(int[] a, int i, int parent) {
		int temp = a[i];
		a[i] =a[parent];
		a[parent] =temp;
		
	}
	
	
	public void heapify(int[] A,int i,int n) {
		int larger = i;
		int left = 2*i;
		int right =2*i +1;
		
		if(left<=n && A[left]>A[larger]) {
			larger =left;
		}
		
		if(right<=n && A[right]>A[larger]) {
			larger =right;
		}
		
		if(larger!=i) {
			swap(A,i,larger);
			heapify(A,larger,n);
		}else {
			return;
		}
	}
	
	public void buildHeap(int[] A ,int n) {
		for(int i= (n/2);i>0;i--) {
			heapify(A,i,n);
		}
	}

	public static void main(String[] args) {
		

	}

}
