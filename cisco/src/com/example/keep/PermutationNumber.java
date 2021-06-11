package com.example.keep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationNumber {
	
	public static void permutationsNumber(Integer arr[]) {
		List<Integer> input = Arrays.asList(arr);
		permutationsNumberUtil(input,new ArrayList<Integer>(), arr.length);
	}
	
	public static void permutationsNumberUtil(List<Integer> input ,List<Integer>ros,int size ) {
		if(ros.size()==size) {
			System.out.println(ros);
			
			return;
		}
		
		for(int i=0;i<input.size();i++) {
			ros.add(input.get(i));
			List<Integer> temp = new ArrayList<Integer>();
			for(int p=0;p<input.size();p++) {
				if(i!=p) {
					temp.add(input.get(p));
				}
			}
			permutationsNumberUtil(temp,ros,size);
			ros.remove(ros.size()-1);
		}
	}

	public static void main(String[] args) {
		Integer[] arr = {1,2,3};
		permutationsNumber(arr);

	}

}
