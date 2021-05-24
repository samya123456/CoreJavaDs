package com.pega;

public class Arrange0s1s2s {
	
	
	public static int[] arrange(int[] arr) {
		int l=0;
		int m=0;
		int h=arr.length-1;
		while(m<=h) {
			if(arr[m]==0) {
				
				int temp =arr[l];
				arr[l] =arr[m];
				arr[m] = temp;
				l++;
				m++;
			}
			else if(arr[m]==1) {
				m++;
			}
			
			else if(arr[m]==2) {
				int temp = arr[h];
				arr[h] = arr[m];
				arr[m]= temp;
				h--;
			}
		}
		
		return arr;
		
	}


	public static void main(String[] args) {
		int arr[] = {0,1,2,0,1,2};
		arrange(arr);

	}

}
