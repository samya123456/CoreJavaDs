package google.com;

import java.util.*;

public class MinimumDominoRotations {
	
	 public static int minDominoRotations(int[] A, int[] B) {
		List<Integer> tempAList = maxValueNumber(A);
		List<Integer> tempBList = maxValueNumber(B);
		 int minChangeA =0;
		 int minChangeB =0;
		if(tempAList.get(1)>tempBList.get(1)) {
			for(int i=0;i<A.length;i++) {
				if(A[i]== tempAList.get(0)) {
					continue;
				}else if(B[i]==tempAList.get(0)) {
					minChangeA++;
				}else {
					return -1;
				}
			}
			return minChangeA==0?-1:minChangeA;
		}else {
			for(int i=0;i<A.length;i++) {
				if(B[i]== tempBList.get(0)) {
					continue;
				}else if(A[i]==tempBList.get(0)){
					minChangeB++;
				}else {
					return -1;
				}
			}
			
		}
		return minChangeB==0?-1:minChangeB;
	          
	   }
	 
	 static  List<Integer>  maxValueNumber(int input[]) {
		 Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
		 List<Integer> op = new ArrayList<Integer>();
		 int n= input.length;
		 for(int i=0;i<n;i++) {
			 if(mp.containsKey(input[i])) {
				 int temp = mp.get(input[i]);
				 mp.put(input[i], temp+1);
			 }else {
				 mp.put(input[i],1);
			 }
		 }
		 
		 Set<Map.Entry<Integer, Integer>> st = mp.entrySet();
		 int maxKey =-1;
		 int maxVal =-1;
		 for(Map.Entry<Integer, Integer> entry:st) {
			 if(entry.getValue()>maxVal) {
				 maxVal =  entry.getValue();
				 maxKey = entry.getKey();
			 }
		 }
		 
		 op.add(maxKey);
		 op.add(maxVal);
		 return op;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[] = {2,1,2,4,2,2}; 
		int B[] = {5,2,6,2,3,2};
		System.out.println(minDominoRotations(A,B));

	}

}
