
public class PermutationBitOps {

	public static void printPermutatins(int[] arr) {
		for (int m = 1; m < 1 << arr.length; m++) {
			for (int i = 0; i < arr.length; i++) {
				if ((m & 1 << i) != 0) {
					System.out.print(arr[i]);
				}
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3 };
		printPermutatins(arr);

	}

}
