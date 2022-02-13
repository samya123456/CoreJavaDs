import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	 public static int[] twoSum(int[] nums, int target) {
	        int arr[] = new int[2];
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i=0;i<nums.length;i++){
	            map.put((target-nums[i]),i);
	        }
	        
	        for(int i=0;i<nums.length;i++){
	            if(map.containsKey(nums[i]) && map.get(nums[i])!=i){
	            	arr[0] = map.get(nums[i]);
	            	arr[1] =i;
	               break;
	            }
	        }
	        
	        return arr;
	        
	        
	    }

	public static void main(String[] args) {

		int[] arr= {3,2,4};
		
		twoSum(arr,6);

	}

}
