import java.util.Arrays;

public class Arrange0s1s2s {
	
	static void arrange(int arr[]) {
		int l=0;
		int m=0;
		int r=arr.length-1;
		
		while(m<=r) {
			if(arr[m]==0) {
				swap(arr,l,m);
				l++;
				m++;
			}else if(arr[m]==1) {
				m++;
			}else if(arr[m]==2) {
				swap(arr,r,m);
				r--;
			}
		}
	}

	private static void swap(int[] arr,int i, int j) {
		int temp =arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

	public static void main(String[] args) {
		int arr[]={0, 1, 2, 0, 1, 2};
		arrange(arr);
		System.out.println(Arrays.toString(arr));

	}

}
