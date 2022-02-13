

public class RottenOranges {
	 int rotOranges(int v[][]) {
		 
		 int row = v.length;
		 int col =v[0].length;
		 int no=2;
		 boolean changed=false;
		 
		while(1==1) {
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(v[i][j]==no) {
						if(isSafe(i+1,j,row,col) && v[i+1][j]==1) {
							 v[i+1][j] = v[i][j]+1;
							 changed=true;
						}
						if(isSafe(i-1,j,row,col) && v[i-1][j]==1) {
							 v[i-1][j] = v[i][j]+1;
							 changed=true;
						}
						if(isSafe(i,j+1,row,col) && v[i][j+1]==1) {
							 v[i][j+1] = v[i][j]+1;
							 changed=true;
						}
						if(isSafe(i,j-1,row,col) && v[i][j-1]==1) {
							 v[i][j-1] = v[i][j]+1;
							 changed=true;
						}
					}
				}
			}
			
			if(!changed) {
				break;
			}
			changed=false;
			no++;
			
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(v[i][j]==1) {
					return -1;
				}
			}
		}
		
		return no-2;
		 
	 }

	private boolean isSafe(int i, int j, int row, int col) {
		if(i<0 ||i>=row ||j<0 ||j>=col) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		 int v[][] = 	{{2, 1, 0, 2, 1},
		                 {1, 0, 1, 2, 1},
		                 {1, 0, 0, 2, 1}};
	 
	System.out.println(new RottenOranges().rotOranges(v));

		

	}

}
