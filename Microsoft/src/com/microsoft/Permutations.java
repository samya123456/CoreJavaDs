package com.microsoft;

public class Permutations {
	
	public static void printPermutations(int arr[]) {
		int n =arr.length;
		
		for(int m =1;m< 1<<n;m++) {
			for(int i=0;i<n;i++) {
				if((m & 1<<i )!=0) {
					System.out.print(arr[i]);
				}
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		
		printPermutations(arr);

	}

}
