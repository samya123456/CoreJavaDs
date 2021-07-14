package google.com;

public class LargestConnectedComponentOnAGrid {
	
	static final int n=6;
	static final int m=8;
	
	
	static final int visited[][] = new int[n][m];
	static final int results[][] = new int[n][m];
	static int count =0;
	static int x=0;
	
	
	
	private static void computeLargestConnectedGrid(int[][] input) {
		
		int current_max = Integer.MIN_VALUE;
		for(int i =0 ;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				
				reset_visited();
				count=0;
				
				if(j+1<m) {
					BFS(input[i][j],input[i][j+1],i,j,input);
				}
				
				if(count>=current_max) {
					current_max=count;
					reset_result(input[i][j],input);
				}
				
				reset_visited();
				count=0;
				
				if(i+1<n) {
					BFS(input[i][j],input[i+1][j],i,j,input);
				}
				
				if(count>=current_max) {
					current_max=count;
					reset_result(input[i][j],input);
				}
			}
		}
		
		print_result(current_max);
		
		
	}

	private static void print_result(int current_max) {
		System.out.println("The result is "+current_max);
		for(int i =0 ;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(results[i][j]!=0) {
					System.out.print(results[i][j]+" ");
				}else {
					System.out.print(". ");
				}
				
			}
			System.out.println();
		}
		
	}

	private static void reset_result(int currentElement, int[][] input) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j]==1 &&
						input[i][j]==currentElement) {
					results[i][j] = currentElement;
					System.out.print(currentElement+" ");
				}else {
					results[i][j]=0;
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		
		System.out.println("----------------------------------------"+x++);
		
	}

	private static void reset_visited() {
		for(int i =0 ;i<n;i++) {
			for(int j=0;j<m;j++) {
				visited[i][j]=0;
				
			}
		}
		
	}

	private static void BFS(int currentElement, int nextElement, int i, int j, int[][] input) {
		if(currentElement!=nextElement) {
			return;
		}
		visited[i][j]=1;
		count++;
		
		int[] x_move= {0,0,-1,1};
		int[] y_move= {1,-1,0,0};
		
		for(int u=0;u<4;u++) {
			if(isValid(i+y_move[u],j+x_move[u],currentElement,input)) {
				BFS(currentElement,nextElement,i+y_move[u],j+x_move[u],input);
			}
		}
		
		
	}

	private static boolean isValid(int i, int j, int currentElement, int[][] input) {
		
		if(i<n && j<m 
				&& i>=0 && j>=0) {
			if(visited[i][j]==0
					&& input[i][j]==currentElement ) {
				return true;
			}else {
				return false;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		  int input[][] = {{1, 4, 4, 4, 4, 3, 3, 1},
                           {2, 1, 1, 4, 3, 3, 1, 1},
                           {3, 2, 1, 1, 2, 3, 2, 1},
                           {3, 3, 2, 1, 2, 2, 2, 2},
                           {3, 1, 3, 1, 1, 4, 4, 4},
                           {1, 1, 3, 1, 1, 4, 4, 4}};

						
						 computeLargestConnectedGrid(input);

	}

	

}
