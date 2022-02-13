import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
	
	public static int singleNumber(int[] nums) {
		  Set<Integer> set = new HashSet();
	        
	        for(int i=0;i<nums.length;i++){
	            if(set.contains(nums[i])){
	                set.remove(nums[i]);
	            }else{
	                set.add(nums[i]);
	            }
	        }
	        return set.iterator().next();
    }

	public static void main(String[] args) {
		int nums[] = {4,1,2,1,2};
		singleNumber(nums);
		
		
	}

}
