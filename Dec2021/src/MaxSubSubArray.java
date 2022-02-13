
public class MaxSubSubArray {
	public static int maxSumSubArray(int[] input) {
		int currentSum =input[0];
		int maxSum = input[0];
		
		for(int i=1;i<input.length;i++) {
			currentSum = Math.max(input[i], input[i]+currentSum);
			maxSum =Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] inputArray = {-2,2,5,-11,6};
		System.out.println(maxSumSubArray(inputArray));

	}

}
