import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinNumberofSwap {

	static int min_swap(int[] arr) {
		int swaps = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ans = 0;
		boolean[] visited = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		Arrays.sort(arr); 
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] || map.get(arr[i]) == i) {
				continue;
			}

			int j = i;
			swaps = 0;
			while (!visited[j]) {
				visited[j] = true;
				j = map.get(arr[j]);
				swaps++;
			}
			if (swaps > 0) {
				ans = ans + swaps - 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		
		  int[] a = { 101, 758, 315, 730, 472,619, 460, 479 };
		  
		  System.out.println(min_swap(a));

	}

}
