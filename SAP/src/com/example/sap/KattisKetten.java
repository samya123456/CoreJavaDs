package com.example.sap;

import java.util.*;

public class KattisKetten {
	
	public static void findKattisKetten(List<List<Integer>> Input) {
		for(int i =0;i<Input.size();i++) {
			List<Integer> list = Input.get(i);
			Collections.sort(list,Collections.reverseOrder());
			Integer KettenSum = list.get(1);
			Integer KettisSum = list.get(0);
			for(int x=2;x<list.size();x=x+2) {
				
				
				if((KettisSum - KettenSum) > (list.get(x) - list.get(x+1))) {
					KettisSum = KettisSum + list.get(x+1);
					KettenSum = KettenSum + list.get(x);
				}else{
					KettisSum = KettisSum+list.get(x);
					KettenSum = KettenSum +list.get(x+1);
				}
			}
			System.out.println(KettisSum+" "+KettenSum);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> Input = new ArrayList<List<Integer>>();
		while(sc.hasNextLine()) {
			int size = sc.nextInt();
			if(size==0) {
				break;
			}
			List<Integer> al = new ArrayList<Integer>();
			for(int i=0;i<size;i++) {
				al.add(sc.nextInt());
			}
			Input.add(al);
		}
		findKattisKetten(Input);
	}

}
