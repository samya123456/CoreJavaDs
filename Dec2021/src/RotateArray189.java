import java.util.Arrays;

public class RotateArray189 {
	
	 public static void rotate(int[] nums, int k) {
	       reverse(nums,0,nums.length-1);
	       reverse(nums,0,k-1);
	       reverse(nums,k,nums.length-1);
	    }
	    
	    private static void reverse(int[] nums,int left,int right){
	        int p = left + (right-left)/2;
	        for(int i =left;i<=p;i++){
	            int temp = nums[i];
	            nums[i] =nums[right-(i-left)];
	            nums[right-(i-left)] =temp;
	        }
	    }

	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums,k);
		System.out.println(Arrays.toString(nums));

	}

}
