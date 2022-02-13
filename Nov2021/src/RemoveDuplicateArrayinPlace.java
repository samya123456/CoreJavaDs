import java.util.Arrays;

public class RemoveDuplicateArrayinPlace {

	public static int[] arrInplaceReplace(int[] arr) {

		int i = 0;
		int j = i + 1;
		int n = arr.length;
		int count = 1;

		while (j < n) {
			
			if (arr[i] == arr[j]) {
				if (count <= 2) {
					arr[i++] = arr[j++];
					count++;

				} else {
					j++;

				}
			} else {
				arr[++i] = arr[j++];
				count = 1;

			}
		}

		for (int k = i + 1; k < n; k++) {
			arr[k] = 0;
		}
		return arr;

	}

	public static void main(String[] args) {
		
		// {1,1,1,1,2,2,3,3,3}
		// one element can appear only twice
		int arr[] = { 1, 2, 2,2,3 };

		System.out.println(Arrays.toString(arrInplaceReplace(arr)));

	}

}
