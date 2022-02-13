import java.util.Arrays;

public class MergeSortInversionCount {
	
	static int sort(int arr[],int l,int r) {
		int m=0,inv_count =0;
		if(l<r) {
			m= l + (r-l)/2;
			inv_count+=sort(arr,l,m);
			inv_count+=sort(arr,m+1,r);
			
			inv_count+=merge(arr,l,m,r);
		}
		return inv_count;
		
		
	}

	private static int merge(int[] arr, int l, int m, int r) {
		int inv_count =0;
		int n1 = (m-l+1);
		int n2 = (r - m);
		int[] L = new int[n1];
		int R[] = new int[n2];
		
		for(int i=0;i<n1;i++) {
			L[i] = arr[l+i];
		}
		
		for(int i=0;i<n2;i++) {
			R[i] = arr[m+1+i];
		}
		
		int i=0;
		int j=0;
		int k=l;
		
		while(i<n1 && j<n2) {
			if(L[i]<=R[j]) {
				arr[k] = L[i++];
			}else {
				arr[k] = R[j++];
				inv_count +=(m-i);
			}
			k++;
		}
		
		while(i<n1) {
			arr[k++] = L[i++];
		}
		
		while(j<n2) {
			arr[k++] =R[j++];
		}
		
		return inv_count;
	}

	public static void main(String[] args) {
		
		int[] arr = {8,4,2,1};
		
		System.out.println(sort(arr,0,arr.length-1));;
		System.out.println(Arrays.toString(arr));
		

	}

}
