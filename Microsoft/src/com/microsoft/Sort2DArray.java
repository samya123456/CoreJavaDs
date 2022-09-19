package com.microsoft;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = new int [][]{
            {4, 9, 8},
            {7, 5, 2},
            {3, 0, 6}};
    
    for(int i = 0; i< arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++)
            System.out.print(arr[i][j] + " ");
            System.out.println();

    }
    Sort2DArrayBasedOnRow(arr);
    System.out.println("---------------------");
    
    for(int i = 0; i< arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++)
            System.out.print(arr[i][j] + " ");
            System.out.println();

    }

	}

	private static void Sort2DArrayBasedOnColumnNumber(int[][] arr, int k) {
		Arrays.sort(arr, new Comparator<int[]>() {
			
			public int compare(int[] first, int[] second) {
				if(first[k-1] > second[k-1]) {
					return 1;
				}else {
					return -1;
				}
			}
		});
		
	}
	
	private static void Sort2DArrayBasedOnRow(int arr[][]) {
		for(int i =0;i<arr.length;i++) {
			Arrays.sort(arr[i]);
		}
	}

}
