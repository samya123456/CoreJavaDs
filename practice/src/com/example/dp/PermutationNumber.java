package com.example.dp;

import java.util.ArrayList;
import java.util.List;

public class PermutationNumber {

	public static void permutationNumber(List<Integer> numbers) {

		List<Integer> restOfNumbers = new ArrayList<Integer>();
		permutationNumberUtil(numbers, restOfNumbers, numbers.size());

	}

	private static void permutationNumberUtil(List<Integer> numbers, List<Integer> restOfNumbers, int size) {
		if (restOfNumbers.size() == size) {
			System.out.println(restOfNumbers);
			return;
		}

		for (int i = 0; i < numbers.size(); i++) {
			restOfNumbers.add(numbers.get(i));
			List<Integer> temp = new ArrayList<Integer>();
			for (int p = 0; p < numbers.size(); p++) {
				if (i != p) {
					temp.add(numbers.get(p));
				}
			}
			permutationNumberUtil(temp, restOfNumbers, size);
			restOfNumbers.remove(restOfNumbers.size() - 1);

		}
	}

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		permutationNumber(numbers);

	}

}
