package google.com;

public class SpiralMatrix2 {
	
	 public static int[][] generateMatrix(int n) {
	        int op[][] = new int[n][n];
	        int left = 0;
	        int right =n-1;
	        int top =0;
	        int buttom = n-1;
	        int dir =0;
	        int count =1;
	        while(top<=buttom && left<=right){
	            if(dir==0){
	                for(int j =left;j<=right;j++){
	                    op[top][j] = count;
	                    count++;
	                }
	                top++;
	            }else if(dir ==1){
	                for(int j= top;j<=buttom ;j++){
	                    op[j][right] = count;
	                    count++;
	                }
	                right--;
	            }else if(dir==2){
	                for(int j=right;j>=left;j--){
	                    op[buttom][j] =count;
	                    count++;
	                }
	                buttom--;
	            }else if(dir==3){
	                for(int j=buttom;j>=top;j--){
	                    op[j][left] =count;
	                    count++;
	                }
	                left++;
	            }
	            
	            dir = (dir+1)%4;
	        }
	        return op;
	    }

	public static void main(String[] args) {
		generateMatrix(3);

	}

}
