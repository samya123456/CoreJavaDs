package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {

	public static int eraseOverlapIntervals(int[][] intervals) {

		int n = intervals.length;

		Arrays.sort(intervals, new Comparator<int[]>() {

			public int compare(int[] a, int[] b) {
				if (a[0] > b[0]) {
					return 1;
				} else if (a[0] == b[0]) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		int left = 0;
		int removal = 0;
		int right = 1;

		while (right < n) {

			if (intervals[left][1] <= intervals[right][0]) {
				left = right;
				right++;
			} else if (intervals[left][1] <= intervals[right][1]) {
				right++;
				removal++;
			} else if (intervals[left][1] > intervals[right][1]) {
				left = right;
				right++;
				removal++;
			}
		}

		return removal;

	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		
		eraseOverlapIntervals(intervals);

	}

}
