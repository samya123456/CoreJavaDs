package com.example.dp;

public class ContainerWithMostWater {
	
	static int containerWithMostWater(int [] height) {
		int i=0;
		int j=height.length-1;
		int max =Integer.MIN_VALUE;
		
		while(i<j) {
			int len = Math.min(height[i],height[j]);
			max = Math.max(max, len* (j-i));
			if(height[i]<height[j]) {
				i++;
			}else {
				j--;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
	int[] height = {1,8,6,2,5,4,8,3,7};
	System.out.println(containerWithMostWater(height));



	}

}
