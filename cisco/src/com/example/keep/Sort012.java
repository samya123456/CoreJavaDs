package com.example.keep;

public class Sort012 {

	public static int[] sort(int[] arr) {
		int h = arr.length - 1;
		int m = 0;
		int l = 0;

		while (m <= h) {
			if (arr[m] == 0) {
				int temp = arr[m];
				arr[m] = arr[l];
				arr[l] = temp;
				m++;
				l++;
			}else if(arr[m]==1) {
				m++;
			}else if(arr[m]==2) {
				int temp = arr[m];
				arr[m] = arr[h];
				arr[h] = temp;
				h--;
				
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {0,2,1,0,2,1};
		arr = sort(arr);
		for(int i:arr) {
			 System.out.println(i);
		}
      
	}

}
