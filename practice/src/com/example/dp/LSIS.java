package com.example.dp;

public class LSIS {
	
	public static int lsis(int[] arr) {
		int n = arr.length;
		int lsis[] = new int[n];
		for(int i=0;i<n;i++) {
			lsis[i] = arr[i];
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]
						&& lsis[i]<arr[i]+lsis[j]) {
					lsis[i]=arr[i]+lsis[j];
				}
			}
		}
		
		int max =0;
		 for (int i = 0; i < n; i++)
	            if (max < lsis[i])
	                max = lsis[i];
		
		
		return max;
		
	}

	public static void main(String[] args) {
		 int arr[] = {1, 101, 2, 3, 100, 4, 5};
		 System.out.println(lsis(arr));
		

	}

}
