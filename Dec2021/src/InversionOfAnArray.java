import java.util.Arrays;

public class InversionOfAnArray {
	
	public static int mergeSortNCount(int[] arr ,int l,int r) {
		int count =0;
		if(l<r) {
			int m = l + (r-l)/2;
			
			count +=mergeSortNCount(arr,l,m);
			count +=mergeSortNCount(arr,m+1,r);
			count +=mergeCount(arr,l,m,r);
		}
		
		return count;
	}

	private static int mergeCount(int[] arr, int l, int m, int r) {
		int[] left = Arrays.copyOfRange(arr, l, m+1);
		int[] right = Arrays.copyOfRange(arr, m+1, r+1);
		int i=0;
		int j=0;
		int swaps =0;
		int k=l;
		
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
				swaps += (m+1) -(i+l);
			}
		}
		while(i<left.length) {
			arr[k++] = left[i++];
		}
		while(j<right.length) {
			arr[k++] = right[j++];
		}
		
		return swaps;
	}

	public static void main(String[] args) {
		 int[] arr = { 1, 20, 6, 4, 5 };
		 System.out.println(
				 mergeSortNCount(arr, 0, arr.length - 1));
		    }

	}


