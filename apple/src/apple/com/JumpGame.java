package apple.com;

public class JumpGame {
	
	public boolean canJump(int[] arr) {
		int lastGoodIndex = arr.length-1;
		
		for(int i= arr.length-1;i>=0;i--) {
			if(i+arr[i]>=lastGoodIndex) {
				lastGoodIndex =i;
			}
		}
		
		return lastGoodIndex==0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1 3 5 8 9 2 6 7 6 8 9 

	}

}
