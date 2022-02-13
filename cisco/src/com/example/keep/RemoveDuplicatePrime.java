package com.example.keep;

import java.util.Arrays;

public class RemoveDuplicatePrime {

	public static void main(String[] args) {
		int[] vect = { 3, 5, 7, 2, 2, 5, 7, 7 };
        vect = removeDups(vect);

	}

	private static int[] removeDups(int[] vect) {
		
		int prod = vect[0];
		int res_ind =1;
		
		for(int i=1;i<vect.length;i++) {
			if(prod%vect[i]!=0) {
				vect[res_ind++] = vect[i];
				prod =prod * vect[i];
			}
		}
		
		return Arrays.copyOf(vect, res_ind);
	}

}
