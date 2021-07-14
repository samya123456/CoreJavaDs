package com.example.sap;

import java.text.DecimalFormat;
import java.util.*;

public class AverageSL {
	
	public static void calculatAvgSl(int noOfTestCases,List<Integer> min,List<Integer> sec) {
		
		double secSum = 0.0;
		double minSum = 0.0;
		double avgSum = 0.0;
		DecimalFormat df = new DecimalFormat("#.#########");
		for(int i=0;i<noOfTestCases;i++) {
			secSum = secSum+sec.get(i);
			minSum = minSum + min.get(i)*60;
		}
		avgSum = secSum/minSum;
		if(avgSum<=1) {
			System.out.println("measurement error");
		}else {
			System.out.println(df.format(avgSum));
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		int input = noOfTestCases;
		List<Integer> min = new ArrayList<Integer>();
		List<Integer> sec = new ArrayList<Integer>();
		while (noOfTestCases!=0) {
			min.add(sc.nextInt());
			sec.add(sc.nextInt());
			noOfTestCases--;
			
		}
		sc.close();
		calculatAvgSl(input,min,sec);
		
	}

}
