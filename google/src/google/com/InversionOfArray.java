package google.com;

import java.util.Arrays;

public class InversionOfArray {
	
	public static int mergeSortNCount(int[] arr ,int left,int right) {
	
		if(arr.length==0) {
			return 0;
		}
		int count =0;
		if(left<right) {
			int mid = left +(right-left)/2;
			
			count+=mergeSortNCount(arr,left,mid);
			count+=mergeSortNCount(arr,mid+1,right);
			count+=mergeNCount(arr,left,mid,right);
		}
		return count;
		
	}

	private static int mergeNCount(int[] arr, int left, int mid, int right) {
		int leftArray[] = Arrays.copyOfRange(arr, left, mid+1); 
		int rightArray[] = Arrays.copyOfRange(arr, mid+1, right+1); 
		
		int i =0;
		int j =0;
		int k =left;
		int swaps =0;
		while(i<leftArray.length && j<rightArray.length) {
			if(leftArray[i]<rightArray[j]) {
				arr[k++] = leftArray[i++];
			}else {
				arr[k++] = rightArray[j++];
				swaps += (mid+1) -(i+left);
			}
		}
		
		while(i<leftArray.length) {
			arr[k++] = leftArray[i++];
		}
		
		while(j<rightArray.length) {
			arr[k++] = rightArray[j++];
		}
		
		return swaps;
	}

	public static void main(String[] args) {
		
		int[] arr = { 1, 20, 6, 4, 5 };
		 System.out.println(
				 mergeSortNCount(arr, 0, arr.length - 1));
		    
		

	}

}
