
public class FloodFill {
	
	public static void floodFill(int[][] screen,int x,int y,int colour) {
		int M = screen.length;
		int N = screen[0].length;
		int ext_colour = screen[x-1][y-1];
		floodFillUtil(screen,x-1,y-1,M,N,ext_colour,colour);
		
	}
	
	public static void floodFillUtil(int[][] screen,int i,int j,int M,int N,int ext_colour, int colour) {
		
		if(i<0 ||i>=M ||j<0 || j>=N || screen[i][j] !=ext_colour) {
			return ;
		}
		
		screen[i][j] = colour;
		
		floodFillUtil(screen,i+1,j,M,N,ext_colour,colour);
		floodFillUtil(screen,i,j+1,M,N,ext_colour,colour);
		floodFillUtil(screen,i-1,j,M,N,ext_colour,colour);
		floodFillUtil(screen,i,j-1,M,N,ext_colour,colour);
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int	screen[][] =  {{1, 1, 1, 1, 1, 1, 1, 1},
		               {1, 1, 1, 1, 1, 1, 0, 0},
		               {1, 0, 0, 1, 1, 0, 1, 1},
		               {1, 2, 2, 2, 2, 0, 1, 0},
		               {1, 1, 1, 2, 2, 0, 1, 0},
		               {1, 1, 1, 2, 2, 2, 2, 0},
		               {1, 1, 1, 1, 1, 2, 1, 1},
		               {1, 1, 1, 1, 1, 2, 2, 1},
	               								};
	int M = screen.length;
	int N = screen[0].length;
	
	floodFill(screen,4,4,5);
	
	for(int i=0;i<M;i++ ) {
		for(int j=0;j<N;j++) {
			System.out.print(screen[i][j]+" ");
		}
		System.out.println();
	}

	}

}
