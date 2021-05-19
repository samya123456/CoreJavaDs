package com.example;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	
	public static int  findOnesBetweenZero(String str) {
		
		char[] arr = str.toCharArray();
		int i=0,j=1;
		int oneCount=0;
		int count=0;
		while(j<arr.length) {
			if(arr[i]=='0' && arr[j]=='1') {
				oneCount++;
				
			}else if(arr[i]=='0' && arr[j]!='1') {
				if(oneCount>0) {
					count++;
					i=j;
					oneCount=0;
				}
			}else {
				i++;
			}
			j++;
		}
		
		return count;
		
	}
	
	public static void replaceAll0with1(Integer val) {
		String str = Integer.toString(val);
		char[] arr = str.toCharArray();
		StringBuffer br = new StringBuffer("");
		for(int i=0 ; i<arr.length;i++) {
			if(arr[i]=='0') {
				br.append('1');
			}else {
				br.append(arr[i]);
			}
		}
		
		System.out.println(br.toString());
	}
	
	public static int mostFrequent(int arr[]) {
		Map<Integer,Integer> intMap = new HashMap<Integer,Integer>();
		int max =0;
		int key =0;
		for(int i =0;i<arr.length;i++) {
			if(intMap.containsKey(arr[i])) {
				int temp =intMap.get(arr[i]);
				intMap.put(arr[i], temp+1);
			}else {
				intMap.put(arr[i],1);
			}
		}
		
		Set<Entry<Integer,Integer>> set = intMap.entrySet();
		for(Entry<Integer,Integer> entry: set) {
			if(max<entry.getValue()) {
				max=entry.getValue();
				key= entry.getKey();
			}
		}
		return key;
	}
	
	public static int permutation(int n,int r) {
		
		return factorial(n)/factorial(n-r);
		
	}
	
	private static int factorial(int n) {
		int out =1;
		for(int i =n;i>1;i--) {
			out*=i;
		}
		return out;
	}
	
	static int findElement(int arr[]) {
		int n = arr.length;
		int[] prefix =new int[n];
		int[] postfix = new int[n];
		prefix[0] = arr[0];
		for (int i=1;i<n;i++) {
			prefix[i] = prefix[i-1] + arr[i];
		}
		postfix[n-1] = arr[n-1];
		for(int j =n-2; j>=0;j--) {
			postfix[j] = postfix[j+1] + arr[j];
		}
		
		for(int p=1;p<n-1;p++) {
			if(prefix[p]==postfix[p]) {
				return arr[p];
			}
		}
		
		return -1;
	}
	
	 public static int maxProfit(int[] prices) {

	        int n = prices.length;
	        int i=0;
	        int j=i+1;
	        int profit =0;
	        while(i<n && j<n){
	            if(prices[i]<prices[j]){
	                profit = profit + (prices[j]-prices[i]);
	               
	            }else{
	                
	            }
	            i++;
	            j=i+1;
	            
	        }
	        
	        return profit;
	        
	 }

	public static void main(String[] args) {
		//System.out.println(findOnesBetweenZero("1111101111010"));
		//replaceAll0with1(5002);
		int arr[] = { 1,2,3,4 ,5};
		//System.out.println(mostFrequent(arr));
		//System.out.println(permutation(4,3));
		System.out.println(maxProfit(arr));
		
	}

}
