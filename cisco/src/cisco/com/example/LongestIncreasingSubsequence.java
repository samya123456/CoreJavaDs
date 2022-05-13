package cisco.com.example;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	
	public int longestIncreasingSubsequence(int[] input) {
		Integer n = input.length;
		Integer[] lis = new Integer[n];
		Arrays.fill(lis, 1);
		
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(input[i]>input[j]
						&& lis[i]<=lis[j]) {
					lis[i] = 1+lis[j];
				}
			}
		}
		
		int max = lis[n-1];
		for(int p=n-1;p>=0;p--) {
			if(max>=1&& max==lis[p]) {
				System.out.println(input[p]);
				max=max-1;
			}
			
		}
		//return Collections.max(Arrays.asList(lis));
		return lis[n-1];
	}
	
	public int maxSumIncreasingSubsequence(int[] input) {
		int n = input.length;
		Integer[] msis = new Integer[n];
		
		for(int i=0;i<n;i++) {
			msis[i]=input[i];
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(input[i]>input[j] && 
					msis[i] < msis[j]+ input[i]) {
					msis[i] = msis[j]+ input[i];
				}
			}
		}
		
		return Collections.max(Arrays.asList(msis));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 101, 2, 3, 100};
		System.out.println(new LongestIncreasingSubsequence().maxSumIncreasingSubsequence(input));
		
		

	}

}
