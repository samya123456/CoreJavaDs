import java.util.Arrays;

public class SpiralMatrix2 {
	
	  public static int[][] generateMatrix(int n) {
	        
	        int left =0;
	        int right =n-1;
	        int top = 0;
	        int buttom =n-1;
	        int dist =0;
	        int[][] output = new int[n][n];
	        int num =1;
	        while(left<=right && top<=buttom){
	            if(dist ==0){
	                for(int i =left;i<=right;i++){
	                    output[top][i] =num++;
	                    top++;
	                }
	            }else if(dist==1){
	                 for(int i =top;i<=buttom;i++){
	                    output[i][right] =num++;;
	                    right--;
	                }
	            }else if(dist==2){
	                 for(int i =right;i>=left;i--){
	                    output[buttom][i] = num++;
	                    buttom--;
	                }
	            }else if(dist==3){
	                 for(int i =buttom;i>=top;i--){
	                    output[i][left] = num++;
	                    left++;
	                }
	            }
	            
	            dist = (dist+1)%n;
	        }
	        
	        return output;
	            
	        
	    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateMatrix(3)));

	}

}
