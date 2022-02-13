package com.example.dp;

public class RottonOranges {

	static int R = 3;
	static int C = 5;

	public static int rotOrgange(int v[][]) {
		
		boolean changed =false;
		int no=2;
		while(true) {
		for(int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				if(v[i][j]==no) {
				if(isSafe(i,j+1) && 
						v[i][j+1]==1) {
					v[i][j+1] = v[i][j]+1;
					changed=true;
				}
				
				if(isSafe(i,j-1) && 
						v[i][j-1]==1) {
					v[i][j-1] = v[i][j]+1;
					changed=true;
					
				}
				if(isSafe(i+1,j) && 
						v[i+1][j]==1) {
					v[i+1][j] = v[i][j]+1;
					changed=true;
					
				}
				if(isSafe(i-1,j) && 
						v[i-1][j]==1) {
					v[i-1][j] = v[i][j]+1;
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
		
		for(int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				
				if(v[i][j]==1) {
					return -1;
				}
			}
		}
		return no-2;
			
		
	}

	private static boolean isSafe(int i, int j) {
		if(i>=0 && i<R &&
				j>=0 && j<C) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		 int v[][] = { { 2, 1, 0, 2, 1 },
                 { 1, 0, 1, 2, 1 },
                 { 1, 0, 0, 2, 1 } };
 
   System.out.println("Max time incurred: " +
		   rotOrgange(v));

	}

}
