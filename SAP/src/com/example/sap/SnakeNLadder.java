package com.example.sap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeNLadder {
	static class Quentry{
		
		int v;
		int dist;
	}
	
	
	public static int getMinNumberOfDice(int nums[],int n) {
		Queue<Quentry> queue = new LinkedList<Quentry>();
		Quentry quentry = new Quentry();
		quentry.v = 0;
		quentry.dist = 0;
		int visited[] = new int[n];
		Arrays.fill(visited, 0);
		visited[0]=1;
		queue.add(quentry);
		
		while(!queue.isEmpty()) {
			quentry = queue.poll();
			int v = quentry.v;
			
			if(v==n-1) {
				break;
			}
			for(int j=(v+1);j<=(v+6)&& j<n;++j) {
				if(visited[j]==0) {
					visited[j] = 1;
					Quentry q = new Quentry();
					q.dist = quentry.dist+1;
					
					if(nums[j]==-1) {
						q.v=j;
					}else {
						q.v =nums[j];
					}
					
					queue.add(q);
				}
			}
			
		}
		
		
		return quentry.dist;
		
	}
	
public static void main(String[] a) {
		
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
        		getMinNumberOfDice(moves, N));
    }

}
