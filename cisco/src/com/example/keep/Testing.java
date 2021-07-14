package com.example.keep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Testing {

	public static List<List<Integer>> getSumZero(int[] arr) {
		List<List<Integer>> op = new ArrayList<List<Integer>>();
		if (arr.length == 0) {
			return null;
		}

		if (arr.length == 1 && arr[0] == 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			op.add(list);
			return op;

		}

		for (int i = 1; i < arr.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
			int sum = arr[i];
			if (arr[i] == 0) {
				list = new ArrayList<Integer>();
				list.add(0);
				op.add(new ArrayList(list));
				continue;
			}
			list.add(sum);
			for (int j = i - 1; j >= 0; j--) {
				sum = sum + arr[j];
				list.add(arr[j]);
				if (sum == 0) {
					op.add(new ArrayList(list));

				}

			}

		}
		return op;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i  = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(i));

	}

}
