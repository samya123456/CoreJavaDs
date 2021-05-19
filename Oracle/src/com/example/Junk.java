package com.example;

public class Junk {
	
	void search (int[][]a , int x) {
		int n = a[0].length;
		
		int i=0, j=n-1;
		
		while(i<n && j>=0) {
			if(a[i][j]==x) {
				System.out.println("i=="+i+ " j=="+j);
				return;
			}
			if(a[i][j]>x) {
				j--;
			}else {
				i++;
			}
		}
	}
	
	void smallestAndLargest(int[]arr) {
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		int smallPos =-1;
		int largePos =-1;
		
		for(int i=0;i<arr.length;i++) {
			if(smallest>arr[i]) {
				smallest = arr[i];
				smallPos =i;
			}
			
			if (largest<arr[i]) {
				largest = arr[i];
				largePos=i;
			}
		}
		
		System.out.println("smallest== "+smallest + " largest=="+largest +" largePos ="+largePos+" smallPos="+smallPos);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int mat[][] = { { 10, 20, 30, 40 },
          //      { 15, 25, 35, 45 },
          //      { 27, 29, 37, 48 },
           //     { 32, 33, 39, 50 } };
		
		//new Junk().search(mat, 29);
		int[] arr = new int[]{2,7,9,5,10,4};
		new Junk().smallestAndLargest(arr);

	}

}
