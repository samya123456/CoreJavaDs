package google.com;

public class Permutations {

	public static void permutaions(char[] arr) {

		int n = arr.length;
		for (int m = 1; m != 1<<n; m++) {
			for (int i = 0; i < n; i++) {
				if ((m & (1 << i)) != 0) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[] arr = {'A','B','C'};
		
		permutaions(arr);

	}

}
