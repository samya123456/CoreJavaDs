package google.com;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {

		int n = height.length;
		int area = Integer.MIN_VALUE;
		int l = 0;
		int r = n - 1;
		while (l < r) {

			int h = Math.min(height[r], height[l]);
			area = Math.max(area, h * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}

		}

		return area;
	}

	public static void main(String[] args) {
		int ip[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(ip));

	}

}
