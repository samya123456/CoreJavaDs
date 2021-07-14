package google.com;

public class FindPeakElement {

	public static int findPeakElement(int[] nums) {
		
		int n = nums.length;
		int left = 0;
		int right= n;
	    
	   
		while(left<right) {
			int mid = left +(right-left)/2;
			if(nums[mid]<nums[mid+1]) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return left;
			
	}

	public static void main(String[] args) {
		int nums[] = {1,2,1,3,5,6,4};
		System.out.println(findPeakElement(nums));
	}

}
