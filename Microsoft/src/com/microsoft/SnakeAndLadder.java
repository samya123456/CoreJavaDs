package com.microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
	
	
	static class Quentry{
		int v;
		int dist;
	}
	
	static int getMinDiceThrows(int move[], int n) {
		int[] visited = new int[n];
		Queue<Quentry> q =  new LinkedList<Quentry>();
		Quentry quentry = new Quentry();
		quentry.v =0;
		quentry.dist = 0;
		visited[0] =1;
		q.add(quentry);
		while(!q.isEmpty()) {
			quentry = q.remove();
			int v = quentry.v;
			if(v==n-1) {
				break;
			}
			for(int j=v+1;j<=(v+6)&& j<n;j++) {
				if(visited[j]==0) {
					Quentry a = new Quentry();
					a.dist = quentry.dist +1;
					visited[j] = 1;
					if(move[j]!=-1) {
						a.v=move[j];
					}else {
						a.v =j;
					}
					q.add(a);
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
                          getMinDiceThrows(moves, N));
    }
		
	

}
