package apple.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum239 {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		
		int n = nums.length;
		int output[] = new int[n - k + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int l = 0;
		int i = 0;
		int r = 0;
		
		while (r < n) {
			
			queue.add(nums[r]);

			if (r - l + 1 < k) {
				r++;

			} else if (r - l + 1 == k) {
				output[i++] = queue.peek();
				if(nums[l] == queue.peek()) {
					queue.poll();
				}
				
				l++;
				r++;
				
			}

		}

		return output;
	}

	public static void main(String[] args) {
		int nums[] = {1,3,-1,-3,5,3,6,7};
		int k =3;
		
		System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));;

	}

}
