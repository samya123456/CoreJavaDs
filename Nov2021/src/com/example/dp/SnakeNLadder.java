package com.example.dp;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeNLadder {
	
	static class Qentry{
		int v ;
		int dist;
	}
	
	public static int getMinDiceThrown(int move[] ,int n) {
		
		int visited[] = new int[n];
		Queue<Qentry> queue = new LinkedList<Qentry>();
		visited[0] =1;
		Qentry q= new Qentry ();
		q.dist=0;
		q.v=0;
		
		queue.add(q);
		
		while(!queue.isEmpty()) {
			 q = queue.remove();
			int v= q.v;  
			
			
			if(v==n-1) {
				break;
			}
			
			for(int j= v+1;j<=(v+6) && j<n;++j) {
				if(visited[j] ==0) {
					visited[j] =1;
					Qentry temp= new Qentry ();
					temp.dist = q.dist+1;
					
					if(move[j]!=-1) {
						temp.v =  move[j];
					}else {
						temp.v = j;
					}
					queue.add(temp);
				}
			}
		}
		
		return q.dist;
		
	}

	public static void main(String[] args) {
		 int N = 30;
	        int moves[] = new int[N];
	        for (int i = 0; i < N; i++)
	            moves[i] = -1;
	 
	        // Ladders
	        moves[2] = 21;
	        moves[4] = 7;
	        moves[10] = 25;
	        moves[19] = 28;
	 
	        // Snakes
	        moves[26] = 0;
	        moves[20] = 8;
	        moves[16] = 3;
	        moves[18] = 6;
	 
	        System.out.println("Min Dice throws required is " +
	        		getMinDiceThrown(moves, N));

	}

}
