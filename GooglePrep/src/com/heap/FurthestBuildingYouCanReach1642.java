package com.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach1642 {
	
	
	 public static int furthestBuilding(int[] heights, int bricks, int ladders) {
	        int i;
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	        for(i =1;i<heights.length;i++){
	            if(heights[i-1] >= heights[i]){
	                continue;
	            }else {
	                int neededBricks = heights[i] - heights[i-1];
	                if( bricks >= neededBricks){
	                    bricks -=neededBricks;
	                    maxHeap.add(neededBricks);
	                }else if(ladders >0){
	                	
	                	if(!maxHeap.isEmpty()) {
	                		
	                	
	                        int max = maxHeap.peek();
	                        if(max > neededBricks) {
	                        	bricks +=max;
	 	                        maxHeap.remove();
	 	                        maxHeap.add(neededBricks);
	 	                        bricks -= neededBricks;
	                        }
	                        
	                	}
	                       
	                        ladders--;
	                    }else{
	                       break;
	                    }
	                
	            }
	        }
	        
	        return i-1;
	        
	    }

	public static void main(String[] args) {
		int buildings[] = {1,13,1,1,13,5,11,11};
		int bricks =10;
		int ladder =8;
		System.out.println(furthestBuilding(buildings,bricks,ladder));
		


	}

}
