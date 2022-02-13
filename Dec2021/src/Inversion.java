import java.util.Arrays;

public class Inversion {
	
	public  static int mergeSortAndCount(int[] arr, int l,int r){
		
		int count =0;
		if(l<r) {
			
			int m = l+ (r-l)/2;
			count +=mergeSortAndCount(arr,l,m);
			count +=mergeSortAndCount(arr,m+1,r);
			count +=mergeAndCount(arr,l,m,r);
		}
		return count;
			
	}

	private static int mergeAndCount(int[] arr, int l, int m, int r) {
		int swaps =0;
		int k = l;
		int i=0;
		int j=0;
		int[] left = Arrays.copyOfRange(arr, l,m);
		int[] right = Arrays.copyOfRange(arr, m+1,r);
		
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
				swaps =(m+1) -(l+i);
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
		
	}

}
