package com.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonCodingTestHeaviestPackage {
	
	
	public static long getHeaviestPackage(List<Integer> packageWeights) {
		
		boolean wasMergeDone = false;
	    List<Integer> mergedWeightList = new ArrayList<>();
	    for (Integer i = packageWeights.size() - 1; i >= 0; i--) {
	        if (i == 0) {
	            mergedWeightList.add(packageWeights.get(i));
	            break;
	        }
	        if (!wasMergeDone && packageWeights.get(i) > packageWeights.get(i - 1)) {
	            mergedWeightList.add(packageWeights.get(i - 1) + packageWeights.get(i));
	            i = i - 1;
	            wasMergeDone = true;
	            continue;
	        }
	        mergedWeightList.add(packageWeights.get(i));
	    }

	    Collections.reverse(mergedWeightList);
	    if (isArraySortedInReverse(mergedWeightList, mergedWeightList.size())) {
	        return mergedWeightList.get(0);
	    }

	    return getHeaviestPackage(mergedWeightList);
	}
	
	public static boolean isArraySortedInReverse(List<Integer> list, int n)
	{
	    if (list == null || n == 0 || n == 1)
	        return true;

	    if (list.get(n - 1) > list.get(n - 2))
	        return false;
	    else
	        return isArraySortedInReverse(list, n - 1);
	}

	public static void main(String[] args) {
		List<Integer> packageWeights = new ArrayList<>();
		packageWeights.add(2);
		packageWeights.add(9);
		packageWeights.add(10);
		packageWeights.add(3);
		packageWeights.add(7);
		
		System.out.println(getHeaviestPackage(packageWeights));;
		

	}

}
