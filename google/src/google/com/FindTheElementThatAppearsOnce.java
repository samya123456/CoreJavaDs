package google.com;

public class FindTheElementThatAppearsOnce {
	
	static int getSingle(int arr[], int n)
    {
        int ones = 0;
        int twos = 0;
       
 
        for (int i = 0; i < n; i++) {
           ones = (ones ^ arr[i]) &(~twos); //(ones XOR arr[i]) AND(complement of twos)
           twos = (twos ^ arr[i]) &(~ones); //(twos XOR arr[i]) AND(complement of ones)
           
        }
        return ones;
    }

	public static void main(String[] args) {
		 int arr[] = { 3, 3, 2, 3 };
	        int n = arr.length;
	        System.out.println("The element with single occurrence is " + getSingle(arr, n));
	        
	        
	}

}
