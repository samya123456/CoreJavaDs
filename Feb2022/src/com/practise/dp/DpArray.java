package com.practise.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DpArray {

	public static int lis(int arr[]) {
		int n = arr.length;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
					dp[i] = 1 + dp[j];
				}
			}
		}
		int max = Integer.MIN_VALUE;

		for (int e : dp) {
			max = Math.max(max, e);
		}

		return max;

	}

	public static int msis(int arr[]) {

		int n = arr.length;
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for (int e : dp) {
			max = Math.max(max, e);
		}

		return max;
	}

	public static int longestCommonSubString(String A, String B) {
		int n = A.length();
		int m = B.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}

	public static int minEdit(String A, String B) {
		int n = A.length();
		int m = B.length();
		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}

			}
		}
		return dp[n][m];
	}

	public static String longestPalindromeSubString(String input) {
		int n = input.length();
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			int len1 = expandFromMiddle(input, i, i);
			int len2 = expandFromMiddle(input, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > (end - start)) {
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}
		}

		return input.substring(start, end + 1);
	}

	private static int expandFromMiddle(String input, int left, int right) {

		if (input == null || left > right)
			return 0;

		while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static int maxSumSubArray(int[] arr) {

		int currSum = arr[0];
		int maxSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			currSum = Math.max(arr[i], currSum + arr[i]);
			maxSum = Math.max(maxSum, currSum);
		}

		return maxSum;
	}

	public static int maxStations(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int noOfStation = 1;
		int maxStations = 1;
		int i = 1;
		int j = 0;
		while (i < n && j < n) {
			if (arr[i] < dep[j]) {
				noOfStation++;
				i++;
				maxStations = Math.max(maxStations, noOfStation);
			} else {
				noOfStation--;
				j++;
			}
		}

		return maxStations;
	}

	public static void permutationsString(String input) {
		if (input == null) {
			return;
		}
		permutationsStringUtils(input, "");
	}

	private static void permutationsStringUtils(String input, String restOfString) {
		if (input.length() == 0) {
			System.out.println(restOfString);
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			String newIp = input.substring(0,i) + input.substring(i+1);
			permutationsStringUtils(newIp,restOfString+ch);
		}

	}
	
	public static void spiralRotations(int[][] arr) {
		
		int l =0;
		int r = arr.length-1;
		int t=0;
		int b =arr.length-1;
		int dir =0;
		
		while(l<=r && t<=b) {
			if(dir==0) {
				for(int i=l;i<=r;i++) {
					System.out.println(arr[t][i]);
				}
				t++;
			}else if(dir==1) {
				for(int i=t;i<=b;i++) {
					System.out.println(arr[i][r]);
				}
				r--;
			}else if(dir==2) {
				for(int i=r;i>=l;i--) {
					System.out.println(arr[b][i]);
				}
				b--;
			}else if(dir==3) {
				for(int i=b;i>=t;i--) {
					System.out.println(arr[i][l]);
				}
				l++;
			}
			
			dir =(dir+1)%4;
		}
	}
	
	
	public static void generateParenthesis(int n) {
		generateParenthesisUtil("",0,0,n);
	}
	
	private static void generateParenthesisUtil(String parenthesis,int open,int close, int max) {
		if(parenthesis.length()==max*2) {
			System.out.println(parenthesis);
			return;
		}
		if(open<max)generateParenthesisUtil(parenthesis+"(",open+1,close,max);
		if(close<open)generateParenthesisUtil(parenthesis+")",open,close+1,max);
	}
	
	
	public static int mostWater(int arr[]) {
		int left = 0;
		int right = arr.length-1;
		int max = Integer.MIN_VALUE;
		while(left<=right) {
			int min = Math.min(arr[left], arr[right]);
			max = Math.max(max, (right-left)*min);
			if(arr[left]>arr[right]) {
				right--;
			}else {
				left++;
			}
		}
		return max;
	}
	
	public static int longestStringWORepeatingChar(String input) {
		Set<Character> set = new HashSet<Character>();
		int i =0;
		int j=1;
		set.add(input.charAt(0));
		int max=1;
		while(j<input.length()) {
			if(!set.contains(input.charAt(j))) {
				set.add(input.charAt(j));
				j++;
				
			}else {
				set.remove(input.charAt(i));
				i++;
			}
			
			max = Math.max(max,j-i);
		}
		return max;
	}
	
	public static int maxPrice(int[] price,int[] len,int maxLength,int N,int[][]dp) {
		if (N==0 || maxLength==0) {
			return 0;
		}
		if(len[N-1]>maxLength) {
			dp[N-1][maxLength] = maxPrice(price,len,maxLength,N-1,dp);
		}else {
			dp[N-1][maxLength] = Math.max(price[N-1] +  maxPrice(price,len,maxLength-len[N-1],N,dp),
					maxPrice(price,len,maxLength,N-1,dp));
		}
		
		return dp[N-1][maxLength];
	}
	
	
	public static int minSwap(int arr[]) {
		int n = arr.length;
		boolean visited[] = new boolean[n];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			map.put(arr[i],i);
		}
		int ans =0;
		
		for(int i=0;i<n;i++) {
			if(visited[i] || map.get(arr[i])==i) {
				continue;
			}
			int j=i;
			int cycle_size=0;
			while(!visited[j]) {
				visited[j] =true;
				j = map.get(arr[j]);
				cycle_size++;
			}
			if(cycle_size>0) {
				ans +=(cycle_size-1);
			}
		}
		return ans;
		
	}
	
	public static int largestSubArray(int arr[]) {
		
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int max_len =0;
		int sum =0;
		
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(arr[i]==0 && max_len==0) {
				max_len =1;
			}
			
			if(sum==0) {
				max_len =i+1;
			}
			
			Integer prev_i = map.get(sum);
			if(prev_i!=null) {
				max_len  = Math.max(max_len, i-prev_i);
			}else {
				map.put(sum, i);
			}
		}
		
		return max_len;
	}
	
	
	public static int megreSortNCount(int arr[],int l,int h) {
		
		int count =0;
		if(l<h) {
			int m= l+ (h-l)/2;
			count+=megreSortNCount(arr,l,m);
			count+=megreSortNCount(arr,m+1,h);
			count+=mergeNCount(arr,l,m,h);
		}
		return count;
		
	}

	private static int mergeNCount(int[] arr, int l, int m, int h) {
		int[] left = Arrays.copyOfRange(arr, l, m+1);
		int[] right = Arrays.copyOfRange(arr, m+1, h+1);
		int i=0;
		int j=0;
		int k=l;
		int swaps = 0;
		
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
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
	
	public static  void printPermutations(int arr[]) {
		
		
		for(int m =1;m< 1<<arr.length;m++) {
			for(int i=0;i<arr.length;i++) {
				if((m & 1<<i)!=0) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
		}
	}
	
	
	public static int[] plusOne(int arr[]) {
		
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]<9) {
				arr[i]++;
				return arr;
			}
			arr[i]=0;
		}
		int nums[] =new int[arr.length+1];
		nums[0] =1;
		return nums;
	}
	
	public int sqrt(int x) {
		int start =1;
		int end =x;
		int res =0;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(mid<=x/mid) {
				res =mid;
				start =mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return res;
	}
	
	public static int jumps(int arr[]) {
		int jumps=0;
		int currentEnd=0;
		int nextEnd=0;
		for(int i=0;i<arr.length-1;i++) {
			nextEnd = Math.max(nextEnd, i+arr[i]);
			if(i==currentEnd) {
				jumps++;
				currentEnd = nextEnd;
				
			}
		}
		
		return jumps;
	}

	public static void main(String[] args) {
	
		
		
	}

}
