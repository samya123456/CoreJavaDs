package google.com;

public class FindNthLowest {
	
	public static int findNthLowest(int[] arr , int m) {
		int n= arr.length;
		int start =0;
		int end = n-1;
		int element = arr[0];
		int[] newArray = new int[n];
		for(int i=0;i<n ;i++) {
			if(arr[i]<=element) {
				newArray[start++] = arr[i];
			}else {
				newArray[end--] = arr[i];
			}
			element = arr[i];
		}
		
		return newArray[m];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,5,6,10,11,3,15};
		System.out.println(findNthLowest(arr,3));;
		//2,5,6,10,11,3,15     3rd  ans = 5

	}

}
