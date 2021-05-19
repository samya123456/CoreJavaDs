package google.com;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> op = new ArrayList<List<Integer>>();
		 List<Integer> list = new ArrayList<Integer>();
		 findCombination(list,0,target,candidates,op);
		 return op;
	        
	    }
	 
	 public static void findCombination(List<Integer> list , int index,int target,int[] candidates,List<List<Integer>> result) {
		 if(index==candidates.length) {
			 if(target==0) {
				 result.add(new ArrayList<Integer>(list));
			 }
			 return;
		 }
		 
		 if(candidates[index]<=target) {
			 list.add(candidates[index]);
			 findCombination(list,index,target-candidates[index],candidates,result);
			 list.remove(list.size()-1);
		 }
		 findCombination(list,index+1,target,candidates,result);
	 }

	

	public static void main(String[] args) {
		
	//	Input: candidates = [2,3,6,7], target = 7
		//		Output: [[2,2,3],[7]]
		int[] candidates = {2,3,6,7};
		combinationSum(candidates,7);

	}

}
