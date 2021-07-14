package google.com;

import java.util.Arrays;

public class NextPermutation {
	
	public static int[] nextPermutations(int nums[]) {
		int n = nums.length;
		int i=1;
		int lastInc =-1;
		if(n==1) {
			return nums;
		}
		
		while(i<n) {  //Find the peak of last ASC 
			if(nums[i]>nums[i-1]) {
				lastInc =i;
			}
			i++;
		}
		
		if(lastInc==-1) { //Check if array is DSC
			for(int j=0;j<(n/2);j++) {
				int temp = nums[i];
				nums[i] = nums[n-1-i];
				nums[n-1-i]=temp;
			}
			return nums;
		}
		
		int index = lastInc;
		
		for(int j=lastInc+1;j<n;j++) {
			if(nums[j]>nums[lastInc-1] && nums[j]<nums[lastInc]) {
				index =j;
			}
		}
		int temp = nums[index];
		nums[index] = nums[lastInc-1];
		nums[lastInc-1] =temp;
		Arrays.sort(nums, lastInc, n);
		return nums;
		
	}

	public static void main(String[] args) {
		int nums[] = {1,3,2};
		int op[]=nextPermutations(nums);
		
		System.out.println(Arrays.toString(op));

	}

}
