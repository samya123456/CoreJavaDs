package com.greedy;

import java.util.Arrays;

public class TaskScheduler621 {
	
	 public static int leastInterval(char[] tasks, int n) {
	        
	        int char_map[] = new int[26];
	        
	        for(char ch : tasks){
	            char_map[ ch - 'A']++;
	        }
	        
	        Arrays.sort(char_map);
	        int maxVal = char_map[25] -1;
	        int idleTime = maxVal*n;
	        
	        for(int i =24;i>=0;i--){
	            idleTime -= Math.min(char_map[i] , maxVal);
	        }
	        
	        return idleTime > 0 ? tasks.length + idleTime:  tasks.length ;
	        
	    }

	public static void main(String[] args) {
		char tasks[] = {'A','A','A','B','B','B'};
		int n = 2;
		
		leastInterval(tasks,n);

	}

}
