package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Dp {

	public static int lis(int arr[]) {
		int n = arr.length;
		int lis[] = new int[n];
		Arrays.fill(lis, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < 1 + lis[j]) {
					lis[i] = 1 + lis[j];
				}
			}
		}

		return lis[n - 1];
	}

	public static int msis(int arr[]) {
		int n = arr.length;
		int[] msis = new int[n];
		for (int i = 0; i < n; i++) {
			msis[i] = arr[i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
					msis[i] = msis[j] + arr[i];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i : msis) {
			max = Math.max(max, i);
		}

		return max;
	}

	public static int longestCommonSubstring(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];

		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				if (i == 0) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] = 0;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(i - 1)) {
						dp[i][j] = 1 + dp[i - 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
		}

		return dp[n1][n2];
	}

	public static int minEdit(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}

		return dp[n][m];
	}

	public static String longestPalindromeSubString(String input) {
		if (input.length() == 0) {
			return "";
		}

		int high = 0;
		int low = 0;

		for (int i = 0; i < input.length(); i++) {

			int len1 = expandFromMiddle(input, i, i);
			int len2 = expandFromMiddle(input, i, i + 1);
			int len = Math.max(len1, len2);

			if (len > (high - low)) {
				high = i + (len / 2);
				low = i - (len - 1) / 2;
			}
		}

		return input.substring(low, high + 1);
	}

	private static int expandFromMiddle(String input, int left, int right) {
		if (input.length() == 0) {
			return 0;
		}

		while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;
	}

	public static int maxSumSubArray(int arr[]) {
		int max_sum = Integer.MIN_VALUE;
		int current_sum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			current_sum = Math.max(arr[i], current_sum + arr[i]);
			max_sum = Math.max(max_sum, current_sum);
		}

		return max_sum;

	}

	public static int minPlatform(int arr[], int dep[]) {
		int i = 1;
		int j = 0;
		int max_platform = 1;
		int required_platform = 1;

		while (i < arr.length) {
			if (arr[i] < dep[j]) {
				required_platform++;
				i++;
				if (required_platform > max_platform) {
					max_platform = required_platform;

				}
			} else {
				required_platform--;
				j++;
			}
		}

		return max_platform;
	}

	public static void permutationNumber(Integer arr[]) {
		List<Integer> input = Arrays.asList(arr);
		List<Integer> rol = new ArrayList<Integer>();

		permutationNumberUtil(input, rol);
	}

	private static void permutationNumberUtil(List<Integer> input, List<Integer> rol) {
		if (input.size() == 0) {
			System.out.println(rol);
			return;
		}

		for (int i = 0; i < input.size(); i++) {
			rol.add(input.get(i));
			List<Integer> newIp = new ArrayList<Integer>();
			for (int p = 0; p < input.size(); p++) {
				if (i != p) {
					newIp.add(input.get(p));
				}
			}
			permutationNumberUtil(newIp, rol);
			rol.remove(rol.size() - 1);
		}

	}

	public static void permutationString(String input) {
		permutationStringUtil(input, "");
	}

	private static void permutationStringUtil(String input, String ros) {
		if (input.length() == 0) {
			System.out.println(ros);
		}

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			String newIp = input.substring(0, i) + input.substring(i + 1);
			permutationStringUtil(newIp, ros + ch);

		}

	}

	public static void spiralRotations(int arr[][]) {
		int left = 0;
		int right = arr.length - 1;
		int top = 0;
		int buttom = arr.length - 1;
		int dir = 0;
		while (left <= right && top <= buttom) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					System.out.print(arr[top][i] + " ");
				}
				top++;
			} else if (dir == 1) {
				for (int i = top; i <= buttom; i++) {
					System.out.print(arr[i][right] + " ");
				}
				right--;
			} else if (dir == 2) {
				for (int i = right; i >= left; i--) {
					System.out.print(arr[buttom][i] + " ");
				}
				buttom--;
			} else if (dir == 3) {
				for (int i = buttom; i >= top; i--) {
					System.out.print(arr[i][left] + " ");
				}
				left++;
			}

			dir = (dir + 1) % 4;
		}
	}

	public static boolean isValidParemthesis(String input) {

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if (isClosingParenthesis(temp)) {
				if (stack.isEmpty()) {
					return false;
				} else {
					char top = stack.peek();
					if (oppositeChar(top) == temp) {
						stack.pop();
					} else {
						return false;
					}
				}
			} else {
				stack.add(temp);
			}
		}

		return stack.isEmpty();

	}

	private static boolean isClosingParenthesis(char ch) {
		if (ch == ')' || ch == '}' || ch == ']') {
			return true;
		}
		return false;
	}

	private static char oppositeChar(char ch) {
		if (ch == '(') {
			return ')';
		} else if (ch == '{') {
			return '}';
		} else if (ch == '[') {
			return ']';
		}
		return '0';
	}

	public static int containerWithMostWater(int arr[]) {
		int left = 0;
		int right = arr.length - 1;
		int area = 0;

		while (left <= right) {
			area = Math.max(area, (right - left) * Math.min(arr[left], arr[right]));
			if (arr[left] < arr[right]) {
				left++;
			} else {
				right--;
			}
		}

		return area;
	}

	public static int trappingRain(int arr[]) {
		int left = 1;
		int right = arr.length - 2;
		int max_left = arr[0];
		int max_right = arr[arr.length - 1];
		int area = 0;
		while (left <= right) {
			if (max_left < max_right) {
				if (arr[left] < max_left) {
					area += (max_left - arr[left]);
				} else {
					max_left = arr[left];
				}

				left++;
			} else {
				if (arr[right] < max_right) {
					area += (max_right - arr[right]);
				} else {
					max_right = arr[right];
				}

				right--;
			}
		}

		return area;
	}

	public static int longestSubstringWithoutRepeatingChar(String input) {

		Set<Character> set = new HashSet<Character>();
		int i = 0;
		int j = 1;
		set.add(input.charAt(0));

		int max = 1;

		while (j < input.length()) {
			if (!set.contains(input.charAt(j))) {
				set.add(input.charAt(j));
				j++;
				max = Math.max(max, set.size());
			} else {
				set.remove(input.charAt(i));
				i++;
			}
		}

		return max;

	}

	public static int cuttingRod(int[] price) {
		int N = price.length;
		int maxLength = N;
		int len[] = new int[N];
		for (int i = 0; i < N; i++) {
			len[i] = i + 1;
		}
		int dp[][] = new int[N + 1][N + 1];
		return cuttingRodUtil(len, price, dp, maxLength, N);
	}

	private static int cuttingRodUtil(int len[], int[] price, int[][] dp, int maxLength, int N) {
		if (N == 0 || maxLength == 0) {
			return 0;
		}

		if (N > maxLength) {
			dp[N][maxLength] = cuttingRodUtil(len, price, dp, maxLength, N - 1);
		} else {
			dp[N][maxLength] = Math.max(price[N - 1] + cuttingRodUtil(len, price, dp, maxLength - len[N - 1], N),
					cuttingRodUtil(len, price, dp, maxLength, N - 1));
		}

		return dp[N][maxLength];
	}

	public static int decodeWays(String input) {
		int n = input.length();
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = input.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			int onedigit = Integer.valueOf(input.substring(i - 1, i));
			int towdigit = Integer.valueOf(input.substring(i - 2, i));
			if (onedigit > 0) {
				dp[i] += dp[i - 1];
			}

			if (towdigit > 9 && towdigit <= 26) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[n];

	}

	public static boolean jumpGame(int arr[]) {
		int n = arr.length - 1;
		int lastGoodIndex = n;

		for (int i = n - 1; i >= 0; i++) {
			if (arr[i] + i >= lastGoodIndex) {
				lastGoodIndex = i;
			}
		}

		return lastGoodIndex == 0;
	}

	public static void rotateImage(int[][] arr) {

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (n / 2); j++) {
				int temp = arr[i][n - 1 - j];
				arr[i][n - 1 - j] = arr[i][j];
				arr[i][j] = temp;
			}
		}
	}

	public static int rottenOrrange(int[][] arr) {
		int no = 2;
		boolean changed = false;
		while (true) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					if (arr[i][j] == no) {
						if (isSafe(i + 1, j, arr.length) && arr[i + 1][j] == 1) {
							arr[i + 1][j] = arr[i][j] + 1;
							changed = true;
						}
						if (isSafe(i - 1, j, arr.length) && arr[i - 1][j] == 1) {
							arr[i - 1][j] = arr[i][j] + 1;
							changed = true;
						}
						if (isSafe(i, j + 1, arr.length) && arr[i][j + 1] == 1) {
							arr[i][j + 1] = arr[i][j] + 1;
							changed = true;
						}
						if (isSafe(i, j - 1, arr.length) && arr[i][j - 1] == 1) {
							arr[i][j - 1] = arr[i][j] + 1;
							changed = true;
						}
					}
				}
			}

			if (!changed) {
				break;
			}
			changed = false;
			no++;

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					return -1;
				}
			}
		}

		return no - 2;
	}

	private static boolean isSafe(int i, int j, int n) {
		if (i >= 0 && i < n && j >= 0 && j < n) {
			return true;
		}
		return false;
	}

	public static int coinChange(int coins[], int amount) {
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

	static class Quanty {
		int v;
		int dist;
	}

	public static int snakeNLadder(int[] moves, int N) {
		Queue<Quanty> q = new LinkedList<Quanty>();
		Quanty quanty = new Quanty();
		quanty.v = 0;
		quanty.dist = 0;
		boolean visited[] = new boolean[N];
		q.add(quanty);
		while (!q.isEmpty()) {
			quanty = q.poll();
			int v = quanty.v;

			if (v == N - 1) {
				break;
			}

			for (int i = (v + 1); i <= (v + 6) && i < N; i++) {
				if (!visited[i]) {
					Quanty temp = new Quanty();
					temp.dist = quanty.dist + 1;
					visited[i] = true;

					if (moves[i] == -1) {
						temp.v = i;
					} else {
						temp.v = moves[i];
					}

					q.add(temp);
				}
			}
		}

		return quanty.dist;
	}

	public static void arrange(int arr[]) {
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(mid, low, arr);
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				swap(mid, high, arr);
				high--;
			}
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static int findCelebrety(int[][] arr) {
		int candidate = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[candidate][i] == 1) {
				candidate = i;
			}
		}

		for (int j = 0; j < arr.length; j++) {
			if (j != candidate && (arr[candidate][j] == 1 || arr[j][candidate] == 0)) {
				return -1;
			}
		}

		return candidate;
	}

	public static int maxPathSum(int[][] arr) {

		int res = -1;
		for (int i = 0; i < arr.length; i++) {
			arr[0][i] = Math.max(res, arr[0][i]);
		}

		for (int i = 1; i < arr.length; i++) {
			res = -1;
			for (int j = 0; j < arr[0].length; j++) {
				if (j > 0 && j < arr[0].length - 1) {
					arr[i][j] += Math.max(arr[i - 1][j], Math.max(arr[i - 1][j - 1], arr[i - 1][j + 1]));
				} else if (j > 0) {
					arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
				} else if (j < arr[0].length - 1) {
					arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j + 1]);
				}

				res = Math.max(res, arr[i][j]);
			}
		}

		return res;
	}

	public static int getnThlargest(int arr[], int n) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > n) {
				minHeap.remove();
			}
		}

		return minHeap.remove();
	}

	public static int minSwapsToSortArray(int arr[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		Arrays.sort(arr);
		boolean visited[] = new boolean[arr.length];

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			if (visited[i] || map.get(arr[i]) == i) {
				continue;
			}

			int j = i;
			int cycle_count = 0;

			while (!visited[j]) {
				visited[j] = true;
				j = map.get(arr[j]);
				cycle_count++;
			}

			if (cycle_count > 0) {
				ans += (cycle_count - 1);
			}
		}

		return ans;
	}

	public static int numberOfIsland(int arr[][]) {
		int count =0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j]==1) {
					dfsUtil(arr,i,j);
					count++;
				}
			}
		}
		
		return count;

	}

	private static void dfsUtil(int[][] arr, int i, int j) {
		if(i<0 ||i>=arr.length ||j<0 || j>=arr[0].length ||arr[i][j]!=1) {
			return;
		}
		arr[i][j] =2;
		dfsUtil(arr,i+1,j);
		dfsUtil(arr,i-1,j);
		dfsUtil(arr,i,j+1);
		dfsUtil(arr,i,j-1);
		
	}
	
	public static int maxSumSubArraySumZero(int arr[]) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int sum=0;
		int max_len =0;
		
		for(int i=0;i<arr.length;i++) {
			sum +=arr[i];
			
			if(arr[i]==0 && max_len==0) {
				max_len =1;
			}
			
			if(sum==0) {
				max_len=i+1;
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}else {
			 Integer prev_i = map.get(sum);
			 max_len =Math.max(max_len,(i-prev_i));
			}
		}
		
		return max_len;
		
	}
	
	public static int[] plusOne(int arr[]) {
		
		for(int i =arr.length -1;i>=0;i++) {
			if(arr[i]<9) {
				arr[i]++;
				return arr;
			}
			arr[i] =0;
		}
		
		int[] newArr =new int[arr.length+1];
		newArr[0] =1;
		return newArr;
		
	}
	
	public static void removeDuplicateFromSortedArray(int arr[]) {
		int index =2;
		
		for(int i=2;i<arr.length;i++) {
			if(arr[index-2]!=arr[i]) {
				arr[index++] =arr[i];
			}
		}
	}
	
	
	public static int squareRoot(int x) {
		int start =1;
		int end =x;
		int res =0;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(mid<=x/mid) {
				start =mid+1;
				res=mid;
			}else {
				end =mid-1;
			}
		}
		
		return res;
				
				
	}
	
	
	public static int pow(int x ,int n) {
		int m =1;
		if(n<0) {
			m = -1*n;
		}else {
			m=n;
		}
		
		int ans =1;
		while(m>0) {
			if(m%2==1) {
				ans *=x;
				m--;
			}else {
				x =x*x;
				m = m/2;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
	
			System.out.println(pow(3,2));
	}

}
