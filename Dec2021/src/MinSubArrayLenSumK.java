
public class MinSubArrayLenSumK {
	
	
	public static int minSubArray(int arr[],int k) {
		int i =0;
		int current_sum = arr[0];
		int j=1;
		int n =arr.length;
		
		while(j<=n) {
			
			if(current_sum==k) {
				return i;
			}else if(current_sum>k) {
				current_sum = current_sum -arr[i];
				i++;
			}else if(current_sum<k && j<n){
				current_sum +=arr[j];
				j++;
			}
		}
		
  		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,4,20,3,10};
		
		System.out.println(minSubArray(arr,33));

	}

}
