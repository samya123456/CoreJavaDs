
public class RemoveDuplicate {
	
	public static int removeDuplicates(int[] nums) {
       int index =2;
       
       
       for(int i=2;i<nums.length;i++) {
    	   if(nums[index-2]!=nums[i]) {
    		   nums[index++] = nums[i];
    	   }
    	   
       }
       return index;
        
    }

	public static void main(String[] args) {
		int arr[] = {0,0,1,1,1,1,2,3,3};
		removeDuplicates(arr);

	}

}
