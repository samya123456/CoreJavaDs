package google.com;

public class HouseRobber198 {
	
	
	public static int robbHouse(int[] money) {
		if(money.length==0) {
			return 0;
		}
		if(money.length==1) {
			return money[0];
		}
		if(money.length==2) {
			return Math.max(money[0], money[1]);
		}
		
		int[] dp = new int[money.length];
		
		
		dp[0] =money[0];
		dp[1] = Math.max(money[0], money[1]);
		for(int i=2;i<money.length;i++) {
			dp[i] = Math.max(money[i]+dp[i-2], dp[i-1]);
		}
		
		return dp[money.length-1];
	}

	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(robbHouse(nums));

	}

}
