package payPal;

public class LIS {
	
	public static int findLis(int[] arr) {
		int n = arr.length;
		int[] lis = new int[n];
		for(int p=0;p<n;p++) {
			lis[p] =1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && 
						lis[i]<1+lis[j]) {
					lis[i] = 1+lis[j];
				}
			}
		}
		
		return lis[n-1];
	}

	public static void main(String[] args) {
		int[] ip = {5,8,7,1,9};
		System.out.println(findLis(ip));

	}

}
