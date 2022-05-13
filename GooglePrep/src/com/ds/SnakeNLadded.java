package com.ds;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeNLadded {
	
	static class Quentry{
		int val;
		int dist;
	}
	
	public static int getMinDiceThrown(int move[], int n) {
		
		Queue<Quentry> q = new LinkedList<Quentry>();
		boolean visited[] = new boolean[n];
		
		Quentry quentry = new Quentry();
		quentry.val =0;
		quentry.dist =0;
		q.add(quentry);
		visited[0] =true;
		while(!q.isEmpty()) {
			quentry = q.poll();
			int val = quentry.val;
			
			if(val ==n-1) {
				break;
			}
			
			for(int i =(val+1);i<=(val+6) && i<n;i++) {
				if(!visited[i]) {
					visited[i] = true;
					Quentry temp = new Quentry();
					temp.dist =quentry.dist +1;
					if(move[i]!=-1) {
						temp.val = move[i];
					}else {
						temp.val =i;
					}
					
					q.add(temp);
				}
			}
		}
		
		return quentry.dist;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
