package com.example.keep;

public class RemoveDuplicatesFromSortedArrayII {

	public static int removeDuplicates(int[] nums) {
		int rightIndex = 1;
		int n = nums.length;
		int currIndex = 0;
		int limit = Integer.MIN_VALUE;
		while (rightIndex < n) {
			if (nums[currIndex] != limit) {

				if (nums[currIndex] != nums[rightIndex]) {
					currIndex++;
					rightIndex++;
				} else if (nums[currIndex] == nums[rightIndex] && (rightIndex - currIndex) == 1) {
					rightIndex++;
				} else if ((rightIndex - currIndex) > 1) {
					while (rightIndex<n && (nums[currIndex] == nums[rightIndex])) {
						rightIndex++;
					}
					currIndex += 2;
					int copiedElement =(rightIndex-currIndex);
					int temp = currIndex;
					int p = rightIndex+1;
					
					while (rightIndex < n) {
						nums[currIndex++] = nums[rightIndex++];
					}
					currIndex = temp;
					rightIndex = currIndex+1;
					while (copiedElement!=0) {
						nums[n-copiedElement] = limit;
						copiedElement--;
					}
				}
			}else {
				rightIndex++;
			}
			
			
		}

		int count=0;
		int x = n-1;
		while(nums[x]==limit) {
			count++;
			x--;
		}
		
		return n-count;

	}

	public static void main(String[] args) {
		int[] nums = {-1,0,0,0,0,3,3 };
		System.out.println(removeDuplicates(nums));;

	}

}
