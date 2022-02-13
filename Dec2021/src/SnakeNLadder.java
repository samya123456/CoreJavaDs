import java.util.LinkedList;
import java.util.Queue;

public class SnakeNLadder {

	static class Quarty {
		int v;
		int dist;
	}

	static int getMinDiceThrows(int[] moves, int n) {
		Queue<Quarty> queue = new LinkedList<Quarty>();
		Quarty quarty = new Quarty();
		boolean visited[] = new boolean[n];
		quarty.v=0;
		int dist =0;
		quarty.dist=dist;
		queue.add(quarty);
		visited[0] =true;
		while(!queue.isEmpty()) {
			quarty = queue.poll();
			int v =quarty.v;
			
			if(v==n-1) {
				break;
			}
			
			for(int j =v+1;j<=(v+6)&& j<n;++j) {
				if(!visited[j]) {
					Quarty q = new Quarty();
					visited[j] =true;
					q.dist =quarty.dist+1;
					if(moves[j]!=-1) {
						q.v = moves[j];
					}else {
						q.v = j;
					}
					queue.add(q);
				}
				
			}
			
		}
		
		return quarty.dist;
		
		
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
                          getMinDiceThrows(moves, N));

	}

}
