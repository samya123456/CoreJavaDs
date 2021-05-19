package apple.com;

public class BinarySearch {
	
	public static int binarySearch(int arr[],int n) {
		int left = 0;
		int right= arr.length-1;
		
		while(left<=right) {
			int middle = left + (right-left)/2;
			
			if(arr[middle]==n)
				return middle;
			
			if(arr[middle]<n) {
				left = middle +1;
			}else {
				right = middle-1;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String arr[]) {
		int ar[] = {1,2,5,7,9,12};
		System.out.println(binarySearch(ar,7));
	}

}
