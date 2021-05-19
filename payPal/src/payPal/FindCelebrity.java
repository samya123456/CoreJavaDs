package payPal;

public class FindCelebrity {

	
	 static int MATRIX[][] = { { 0, 0, 1, 0 },
             { 0, 0, 1, 0 },
             { 0, 0, 0, 0 },
             { 0, 0, 1, 0 } };
	 
	 static int[][] mat = {{1,2},{2,1},{2,4},{4,3}};
	static int knows(int a, int b) { return MATRIX[a][b]; }
	
	static int findCelebrity(int n) {
		int candidate =0;
		
		for(int i =1;i<n;i++) {
			if(knows(candidate,i)==1) {
				candidate=i;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(i!=candidate && (knows(candidate,i)==1 || knows(i,candidate)==0)) {
				return -1;
			}
		}
		
		return candidate;
	}
	public static void main(String[] args) {
		
		System.out.println(findCelebrity(4));
	}

}
