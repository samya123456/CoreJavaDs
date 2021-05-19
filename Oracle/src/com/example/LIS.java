package com.example;

import java.util.*;

public class LIS {
	
	public static List<String> al = new ArrayList<String>();
	
	public static int longestSubsequence(int size, Integer a[]){
	        
	        Integer[] lis = new Integer[size];
	        
	        for(int p=0;p<size;p++){
	            lis[p] =1;
	        }
	        
	        for(int i=1;i<size;i++){
	            for(int j=0;j<i;j++){
	                if(a[i]>a[j] && lis[j]>=lis[i]){
	                    lis[i] =1+lis[j] ;
	                }
	            }
	        }
	        
	        return Collections.max(Arrays.asList(lis));
	        
	        // code here
	    }
	
	public static int maxSumIS(Integer arr[], int n)  
	{  
	    Integer[] lis = new Integer[n];
	    for(int p=0;p<n;p++){
	        lis[p] = arr[p];
	    }
	    
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(arr[i]>arr[j] &&
	            lis[i]<arr[i]+lis[j]){
	                lis[i] = arr[i]+ lis[j];
	            }
	        }
	    }
	    
	    return Collections.max(Arrays.asList(lis));
	    
	    
	}  
	
	public static int minJump(Integer arr[], int n)  {
		
	int	maxReachable=arr[0];
	int	jumps=1;
	int stepPossible=arr[0];
	
	for(int i=0;i<n;i++) {
		if(i==n-1) {
			return jumps;
		}
		
		maxReachable = Math.max(maxReachable, i+arr[i]);
		stepPossible--;
		if(stepPossible==0) {
			jumps++;
			if(i>=maxReachable) {
				return -1;
			}
			stepPossible=maxReachable-i;
		}
		
	}
	return jumps;
		
	}
	
	 
	 public static void permutaions(String input){
		 permutaionsUtils("",input);
	 }
	 
	 public static List<String> permutaionsUtils(String prefix,String input){
		
		 int n = input.length();
		 if(n==0) {
			 al.add(prefix);
		 }else {
			 for(int i=0;i<n;i++) {
				 permutaionsUtils(prefix + input.charAt(i),input.substring(0,i)+input.substring(i+1, n));
			 }
		 }
		 
		 return al;
	 }
	 
	 public static Character  a(String S) {
		 List<Character> al = new ArrayList<Character>();
	       char[] arr = S.toCharArray();
	      
	       int n = S.length();
	       Map<Character,Integer> st = new LinkedHashMap<Character,Integer>();
	       for(int i=0;i<n;i++){
	        
	           if(!st.containsKey(arr[i])){
	              st.put(arr[i], 1);
	           }
	           else{
	        	   st.put(arr[i], 2);
	               
	               
	           }
	          
	       }
	       
	      Set<Map.Entry<Character,Integer>> s =st.entrySet();
	      for(Map.Entry<Character,Integer> e :s) {
	    	  if(e.getValue()>1) {
	    		  return e.getKey();
	    	  }
	      }
	      return '0';
	 }
	 
	public static void main(String[] args) {
		//Integer [] arr =new Integer[] {1, 3 ,5 ,8 ,9 ,2, 6, 7, 6, 8 ,9};
		//System.out.println(longestSubsequence(4,arr));;
		//maxSumIS(arr,5);
		//System.out.println(minJump(arr,11));
		
		int[] start = new int[] {7, 2, 2, 3};
		int[] end = new int[]{8, 4 ,7 ,10};
		
		//permutaions("abc");
		//for(int i =0;i<al.size();i++) {
			//System.out.println(al.get(i));
		//}
		System.out.println(a("geekforgeeks"));
		
	}

}
