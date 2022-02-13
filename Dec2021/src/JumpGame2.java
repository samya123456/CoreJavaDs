
public class JumpGame2 {

	public static int jump(int[] nums) {
		int jump =0;
		int currentEnd =0;
		int nextEnd =0;
		for(int i=0;i<nums.length-1;i++) {
			nextEnd = Math.max(nextEnd, i+nums[i]);
			if(i==currentEnd) {
				jump++;
				currentEnd =nextEnd;
			}
		}
		return jump;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));

	}

}
