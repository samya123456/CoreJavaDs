package com.example.dp;

public class TrappingWater {

	public static int findMaxWaterOnSpaceComplexity(int[] arr) {
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];
		left[0] = 0;

		if (n <= 2) {
			return 0;
		}

		for (int i = 1; i < n; i++) {

			left[i] = Math.max(left[i - 1], arr[i]);
		}

		right[n - 1] = 0;
		for (int i = n - 2; i >= 0; --i) {

			right[i] = Math.max(right[i + 1], arr[i]);
		}

		int maxWater = 0;
		for (int i = 1; i < n - 1; i++) {

			if (arr[i] < left[i] && arr[i] < right[i]) {
				maxWater +=  Math.min(left[i], right[i]) - arr[i];
			}

		}

		return maxWater;

	}
	
	public static int findMaxWaterO1SpaceComplexity(int[] arr) {
		
		
		int n = arr.length;
		int maxLeft =arr[0];
		int maxRight =arr[n-1];
		int left =1;
		int right =n-2;
		int maxWater =0;
		while(left<=right) {
			
			if(maxLeft<maxRight) {
				if(arr[left]>=maxLeft) {
					maxLeft = arr[left];
				}else {
					maxWater += maxLeft - arr[left];
				}
				left++;
			} else {
				if(arr[right]>maxRight) {
					maxRight = arr[right];
				}else {
					maxWater += maxRight - arr[right];
				}
				
				right--;
			}
			
		}
		
		return maxWater;
		
		
		
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		System.out.println(findMaxWaterO1SpaceComplexity(arr));

	}

}
