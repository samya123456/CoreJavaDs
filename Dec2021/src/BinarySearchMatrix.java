
public class BinarySearchMatrix {
	
	 public static boolean searchMatrix(int[][] matrix, int target) {
	        int N = matrix.length;
	        int M = matrix[0].length;
	        
	        int low  =0;
	        int high = M-1;
	        for(int i=0;i<N;i++){
	        	  low  =0;
	 	          high = M-1;
	          while(low<=high){
	              int mid =low+ (high-low)/2;
	              if(matrix[i][mid]==target){
	                  return true;
	              }else if(matrix[i][mid]>target){
	                  high =mid-1;
	              }else{
	                  low =mid+1;
	              }
	          }
	        }
	        
	        return false;
	        
	    }

	public static void main(String[] args) {
		/*int matrix[][] = {{1,3,5,7},
						  {10,11,16,20},
						  {23,30,34,60}}; */
		int matrix[][] = {{1},{3}};
		searchMatrix(matrix,3);

	}

}
