package google.com;

import java.util.*;

public class PermutationNumber {
	
	 public static List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> op = new ArrayList<List<Integer>>();
	        
	        List<Integer> numsAl = new ArrayList<Integer>();
	        for(int i =0 ;i<nums.length;i++) {
	        	numsAl.add(nums[i]);
	        }
	        permutations(nums.length,numsAl,op,new ArrayList<Integer>());
	        return op;
	    }
	    
	    public static void permutations(int size, List<Integer> numsAl,List<List<Integer>> op ,List<Integer> list ){
	        
	        if(list.size() ==size){
	        	if(!op.contains(list)) {
	        		op.add(new ArrayList<Integer>(list));
	        	}
	            
	            
	            return;
	        }
	        
	     /*   for(int p=0;p<numsAl.size();p++){
	           int num = numsAl.get(p);
	           list.add(num);
	           List<Integer> rol = new ArrayList<Integer>(); 
	           for(int i=0;i<numsAl.size();i++) {
	        	   if(i!=p) {
	        		   rol.add(numsAl.get(i));   
	        	   }
	        	  
	           }
	           
	           permutations(size,rol,op,list);
	           list.remove(list.size()-1);
	         
	        }*/
	        for(int p=0;p<numsAl.size();p++){
	            int num = numsAl.get(p);
	            list.add(num);
	            List<Integer> rol = new ArrayList<Integer>();
	            for(int i=0;i<numsAl.size();i++){
	                if(i!=p){
	                    rol.add(numsAl.get(i));
	                }
	            }
	            permutations(size,rol,op,list);
	            list.remove(list.size()-1);
	        }
	        
	    }

	public static void main(String[] args) {
		int[] input = {1,1,2};
		permute(input);

	}

}
