package com.microsoft;

import java.util.HashMap;
import java.util.Map;

public class NumberofDiceRollsTargetSum {
	
	
	 final int MOD = 1000000007;
	    
	    Map<String,Integer> map = new HashMap<>();
	    
	    public int numRollsToTarget(int n, int k, int target) {
	        if(n > target || target > k*n) {
	            return 0;
	        }
	        if(n==1){
	            if(target>k){
	                return 0;
	            }else{
	                return 1;
	            }
	        }
	        
	        String key ="" +n+k+target;
	        
	        if(!map.containsKey(key)){
	            int sum =0;
	           for(int i=1;i<=k;i++){
	                sum += numRollsToTarget(n-1,k,target-i);
	                sum %= MOD;
	            
	           }
	            
	           map.put(key,sum); 
	        }
	        
	        return map.get(key);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
