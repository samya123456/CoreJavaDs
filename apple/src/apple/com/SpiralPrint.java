package apple.com;

public class SpiralPrint {
	
	static void spiral(int n,int m,int arr[][]) {
	int top =0;
	int down = m-1;
	int left = 0;
	int right =n-1;
	int dir =0;
	int i=0;
	while(top<=down && left<=right) {
		if(dir==0) {
			for(i=left;i<=right;i++) {
				System.out.print(arr[top][i]+" ");
			}
			top++;
		} else if(dir==1) {
			for(i=top;i<=down;i++) {
				System.out.print(arr[i][right]+" ");
			}
			right--;
		} else if(dir==2) {
			for(i=right;i>=left;i--) {
				System.out.print(arr[down][i]+" ");
			}
			down--;
		} else if(dir==3) {
			for(i=down;i>=top;i--) {
				System.out.print(arr[i][left]+" ");
			}
			
			left++;
		}
		
		dir = (dir+1)%4;
	}
	
	}

	public static void main(String[] args) {

		 int a[][] = { { 1, 2, 3, 4 },
				 	   { 5, 6, 7, 8 },
				 	   { 9, 10, 11, 12 },
				 	   { 13, 14, 15, 16 } };
		 spiral(4,4,a);

	}

}
