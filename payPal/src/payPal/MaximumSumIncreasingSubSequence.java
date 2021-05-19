package payPal;

public class MaximumSumIncreasingSubSequence {
	
	public static int  msis(int[] arr) {
		int n = arr.length;
		int msis[] = new int[n];
		for(int p=0;p<n;p++) {
			msis[p] =arr[p];
			
		}
		
		for(int i =1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && 
						msis[i]<arr[i]+msis[j]) {
					msis[i]=arr[i]+msis[j];
				}
			}
		}
		
		return msis[n-1];
	}

	public static void main(String[] args) {
		int arr[] = {1, 101, 2, 3, 100} ;
		System.out.println(msis(arr));

	}

}
