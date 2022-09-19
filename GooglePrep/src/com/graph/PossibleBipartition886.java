package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition886 {
	
	
public static boolean possibleBipartition(int n, int[][] dislikes) {
        
        if(n <= 2){
            return true;
        }
        
        List<Integer> undirectedGraph[] = new ArrayList[n+1];
        
        for(int i =0;i<dislikes.length;i++){
              int parent =   dislikes[i][0];
              int child = dislikes[i][1];
            
              if(undirectedGraph[parent] !=null){
                  List<Integer> children = undirectedGraph[parent];
                  children.add(child);
                  undirectedGraph[parent] = children;
              }else{
                  List<Integer> children = new ArrayList<>();
                  children.add(child);
                  undirectedGraph[parent] = children;
              }
            
              if(undirectedGraph[child] !=null){
                  List<Integer> children = undirectedGraph[child];
                  children.add(parent);
                  undirectedGraph[child] = children;
              }else{
                  List<Integer> children = new ArrayList<>();
                  children.add(parent);
                  undirectedGraph[child] = children;
              }
            
        }
        
        return bfs(undirectedGraph,n);
        
        
    }
    
    private static boolean bfs(List<Integer> undirectedGraph[],int n){
        Queue<Integer> q = new LinkedList<>();
        Boolean[] colours = new Boolean[n+1];
       
        
        q.add(1);
        colours[1] = true;
        boolean AllNotColoured =true;
        while(AllNotColoured){
            
                while(!q.isEmpty()){
                int parent = q.remove();
                List<Integer> children = undirectedGraph[parent];
                boolean parentColour = colours[parent];
                boolean childColour = !parentColour;
                if(children!=null){
                	for(int i =0;i<children.size();i++){
                        int child = children.get(i);
                        if(colours[child] == null){
                           colours[child] = childColour;
                            q.add(child);
                        }else if(colours[child]!=childColour){
                                return false;

                        }
                    }
                	
                }
                
            }
            AllNotColoured =false;
            for(int i =1;i<=n;i++){
                
                if(colours[i]==null){
                    q.add(i);
                    colours[i]=true;
                    AllNotColoured=true;
                    break;
                }
                
            }
            
        }
        
        
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n =5;
		int[][] dislikes = {{1,2},{3,4},{4,5},{3,5}};
		System.out.println(possibleBipartition(n,dislikes));

	}

}
