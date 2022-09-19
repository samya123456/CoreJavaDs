package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KeysRooms841 {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        Map<Integer,Boolean> visitedMap = new HashMap<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        
        while(!q.isEmpty()){
            
            int parent = q.remove();
            if(visitedMap.containsKey(parent)){
                continue;
            }
            visitedMap.put(parent,true);
            List<Integer> childs = rooms.get(parent);
            
            for(int i=0;i<childs.size();i++){
                
                if(!visitedMap.containsKey(childs.get(i))){
                    q.add(childs.get(i));
                }
            }
        }
        
        for(int i =0;i<rooms.size();i++){
            if(!visitedMap.containsKey(i)){
                return false;
            }
        }
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
