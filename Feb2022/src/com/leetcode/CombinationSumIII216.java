package com.leetcode;

import java.util.*;

public class CombinationSumIII216 {
	
	  public static List<List<Integer>>  combinationSum3(int k, int n) {
	        List<List<Integer>> output = new ArrayList<List<Integer>>();
	        List<Integer> current = new ArrayList<Integer>();
	        
	        combinationSum3Util(k,1,n,output,current);
	        return output;
	        
	        
	    }
	  public static void  combinationSum3Util(int k ,int index,int n, List<List<Integer>> output, List<Integer> current){
	        if(current.size()==k){
	            if(n==0){
	                if(!output.contains(current)){
	                    output.add(new ArrayList<Integer>(current)) ;
	                    return;
	                }
	            }else if(n<0){
	                return;
	            }
	        }else if(current.size()>k){
	            return;
	        }
	       for(int i=index;i<=n && i<=9;i++){
	          if(!current.contains(i)){
	             current.add(i);
	             combinationSum3Util(k,i+1,n-i,output,current);
	             current.remove(current.size()-1); 
	          } 
	       }
	      
	    }

	public static void main(String[] args) {
		System.out.println(combinationSum3(3,9));

	}

}
