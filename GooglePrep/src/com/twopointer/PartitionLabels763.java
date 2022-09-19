package com.twopointer;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {

	public static List<Integer> partitionLabels(String s) {

		List<Integer> output = new ArrayList<>();

		int wordend_map[] = new int[26];

		for (int i = 0; i < s.length(); i++) {

			wordend_map[s.charAt(i) - 'a'] = i;

		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {

			end = Math.max(end, wordend_map[s.charAt(i) - 'a']);

			if (i == end) {
				output.add(end - start + 1);
				start = end + 1;

			}
		}
		
		return output;

	}

	public static void main(String[] args) {
		

		String s = "ababcbacadefegdehijhklij";
		
		System.out.println(partitionLabels(s));

	}

}
