package com.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray {
	
public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int output[] = new int[n];
        //Arrays.sort(arr1);
        Map<Integer,Integer> countMapping = new TreeMap<>();
        
        for(int i=0;i<arr1.length;i++){
            
            if(!countMapping.containsKey(arr1[i])){
                
                countMapping.put(arr1[i],1);
                
            }else{
                int count = countMapping.get(arr1[i]);
                
                countMapping.put(arr1[i],count+1);
            }
        }
        
        int index =0;
        
        for(int i=0;i<arr2.length;i++){
            
            if(countMapping.containsKey(arr2[i])){
                
                int count = countMapping.get(arr2[i]);
                
                for(int j=0;j<count;j++){
                    
                    output[index++] = arr2[i];
                }
                
                countMapping.remove(arr2[i]);
            }
        }
        
       for(Map.Entry<Integer,Integer> entry:countMapping.entrySet()) {
    	   int count = entry.getValue();
    	   for(int i=0;i<count;i++) {
    		   output[index++] =  entry.getKey();
    		  
    	   }
       }
        
        return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int arr1[]={2,3,1,3,2,4,6,7,9,2,19};
				int arr2[] ={2,1,4,3,9,6};
				
			System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
			

	}

}
