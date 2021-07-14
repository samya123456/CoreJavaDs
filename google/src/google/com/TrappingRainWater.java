package google.com;

public class TrappingRainWater {
	
    public static int trap(int[] height) {
    	
    	
    	int n = height.length;
    	if(n<=2) {
    		return 0;
    	}
    	int maxLeft =height[0];
    	int maxRight = height[n-1];
    	int left =1;
    	int right =n-2;
    	int trappedWater =0;
    	while(left<=right) {
    		if(maxLeft<maxRight) {
        		if(height[left]<=maxLeft) {
        			trappedWater+=maxLeft- height[left];
        		}else {
        			maxLeft = height[left];
        		}
        		left++;
        	}else {
        		if(height[right]<=maxRight) {
        			trappedWater+=maxRight- height[right];
        		}else {
        			maxRight = height[right];
        			
        		}
        		right--;
        	}
    	}
    	
    	return trappedWater;
    	
    }

	public static void main(String[] args) {
		int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));

	}

}
