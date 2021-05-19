package com.leetcode.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Junk {
	
	 public String longestCommonPrefix(String[] strs) {
	        
	/*	 if(strs.length==0) {
	        	return "";
	    } 
     
     if(strs.length==1){
         return strs[0];
     }
      String op="";
	        String first =strs[0];
	        
	        for(int i=1;i<strs.length;i++){
	        	int j=0;
	            while(j<=first.length() && j<=strs[i].length()) {
	            	if(first.substring(0,j).equals(strs[i].subSequence(0,j))) {
	            		op =first.substring(0,j);
	            		
	            	}
	            	j++;
	            }
	            first = strs[i];
	        }
	        return op; */ 
		 
		 char[] ch = strs[0].toCharArray();
		 int count =0;
		 for (int i=0;i<=ch.length;i++){
			boolean haveinAll =true;
	            for(int j=1;j<strs.length;j++){
	                if(i<=strs[j].length()&&  strs[0].substring(0,i).equals(strs[j].substring(0,i))){
	                 
	                }else {
	                	haveinAll =false;
	                	break;
	                }
	            }
	            
	            if(haveinAll) {
	            	count =i;
	            }
	        }
	        
	        return strs[0].substring(0,count);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		
	        
	    }
	
	 public int reverse(int x) {
	        StringBuffer str = new StringBuffer();
	        int op;
	        int r;
	        int temp =x;
	        if(x<0){
	            x=x*(-1);
	        }
	        
	        
	        
	        while(x!=0){
	            r=x%10;
	            x=x/10;
	            str.append(r);
	               
	        }
	        
	        if(str.toString().length()==1){
	            return temp;
	        }
	        
	      
	           op = (int) Double.parseDouble(str.toString());
	           if(op>= Integer.MAX_VALUE || op<= Integer.MIN_VALUE){
		            return 0;
		        }
	       if(temp<0) {
	    	   op =op *(-1);
	       }
	        
	        return op;
	        
	    }
	  public boolean isPalindrome(int x) {
	        List<Integer> al = new ArrayList<Integer>();
	        int p;
	         boolean flag =false;
	        
	        if(x<0){
	            return false;
	        }
	        while(x!=0){
	            p=x%10;
	            x=x/10;
	            al.add(p);
	        }
	        
	        if(al.size()%2==0){
	            int mid = al.size()/2;
	           flag = isPalindromeUtil(al , mid-1, mid);
	        }else{
	            int mid = al.size()/2;
	            flag = isPalindromeUtil(al , mid, mid);
	        }
	        
	        return flag;
	        
	    }
	    
	    public boolean isPalindromeUtil(List<Integer> al,int left,int right){
	       
	        while(left>=0 && right<al.size()){
	            
	            if(al.get(left)==al.get(right)){
	                
	            }else{
	                return false;
	            }
	            left--;
	            right++;
	        }
	        
	        return true;
	    }
	    
	    public int lastStoneWeight(List<Integer> stones) {
	        if(stones==null)
	            return 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        for (int i = 0; i < stones.size(); i++) {
	            pq.offer(stones.get(i));
	        }
	        while (pq.size() > 1) {
	            int first = pq.poll();
	            int second = pq.poll();
	            if (first != second) {
	                int rem = Math.abs(first - second);
	                pq.offer(rem);
	            }
	        }
	        return pq.size()==1 ? pq.poll() : 0;
	    }
	    
	    public int removeDuplicates(int[] nums) {
	        
	    	 if(nums.length==0){
	             return 0;
	         }
	          int i =0;
	          for(int j=1;j<nums.length;j++){
	              if(nums[i]!=nums[j]){
	                  i++;
	                  nums[i] =nums[j];
	              }
	          }
	          return i+1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] strs ={"aaa","aa","aaa"};
		//String[] strs ={"flower","flow","flight"};
		//String[] strs = {"cir","car"};
		//String[] strs ={"flower","flower","flower","flower"};
		//System.out.println(new Junk().longestCommonPrefix(strs));;
		/*List al = new ArrayList();
		
		
		al.add(2);
		al.add(4);
		al.add(5);
		System.out.println(new Junk().lastStoneWeight(al));*/
		int a[] = {1,1,2};
		System.out.println(new Junk().removeDuplicates(a));
		
		
		
	}

}
