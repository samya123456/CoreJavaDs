import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<Integer>();
        findCombinations(candidates,0,target,current,output);
        return  output;
    }
	
	private static void findCombinations(int candidates[] ,int index,int target,List<Integer> current, List<List<Integer>> output ) {
		if(target==0) {
				if(!output.contains(current)) {
					output.add(new ArrayList<Integer>(current));	
				}
				
			
			
			return;
		}
		if(target<0) {
			return;
		}
		
		for(int i =index;i<candidates.length;i++) {
			//if(i==index || (candidates[i]!=candidates[i-1])) {
				current.add(candidates[i]);
				findCombinations(candidates,i+1,target -candidates[i],current,output);
				current.remove(current.size()-1);
			//}
			
		}
	}

	public static void main(String[] args) {
		int candidates[] = {10,1,2,7,6,1,5};
		int target = 8;
		
		System.out.println(combinationSum2(candidates,target));

	}

}
