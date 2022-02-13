package com.example.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationNumber {
	
	
	public static void permutationNumber(Integer[] arr) {
		List<Integer>input =Arrays.asList(arr);
		List<Integer> restOfNumber = new ArrayList();
		permutationNumberUtil(input,restOfNumber,input.size());
		
	}

	private static void permutationNumberUtil(List<Integer> input, List<Integer> restOfNumber, int size) {
		if(restOfNumber.size()==size) {
			System.out.println(restOfNumber);
			return;
		}
		
		for(int i=0;i<input.size();i++) {
			int num = input.get(i);
			restOfNumber.add(input.get(i));
			List<Integer> newInput =new ArrayList();
			for(int j=0;j<input.size();j++) {
				if(i!=j ) {
					newInput.add(input.get(j));
				}
			}
			permutationNumberUtil(newInput,restOfNumber,size);
			restOfNumber.remove(restOfNumber.size()-1);
		}
		
	}

	public static void main(String[] args) {
		Integer[] arr = {1,2,3};
		permutationNumber(arr);

	}

}
