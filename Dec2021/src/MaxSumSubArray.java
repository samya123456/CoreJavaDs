import java.util.HashMap;
import java.util.Map;

public class MaxSumSubArray {

	public static int maxSum(int[] arr) {
		int max_len = 0;
		int sum = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] == 0 && max_len == 0) {
				max_len = 1;
			}

			if (sum == 0) {
				max_len = i + 1;
			}

			Integer prev_i = map.get(sum);

			if (prev_i != null) {
				max_len = Math.max(max_len, i - prev_i);
			} else {
				map.put(sum, i);
			}
		}
		return max_len;

	}

	public static void main(String[] args) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		
		System.out.println(maxSum(arr));

	}

}
