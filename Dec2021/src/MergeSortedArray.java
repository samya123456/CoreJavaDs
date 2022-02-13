import java.util.Arrays;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int x = m + n - 1;

		while (m > 0 && n > 0) {
			if (nums1[m - 1] < nums2[n - 1]) {
				nums1[x] = nums2[n - 1];
				n--;
			} else {
				nums1[x] = nums1[m - 1];
				m--;
			}
			x--;
		}

		while (n > 0) {
			nums1[x] = nums2[n - 1];
			x--;
			n--;
		}

	}

	public static void main(String[] args) {

		int nums1[] = {0};
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;

		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));

	}

}
