
public class BestTimeBuySellStock {
	
	public static int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }if(prices.length==1){
            return 0;
        }
        int max =0;
        int maxArray[] =new int[prices.length];
        int n=prices.length-1;
        maxArray[n] = prices[n];
        
        for(int i=n-1;i>=0;i--){
            if (maxArray[i+1]>prices[i]){
                 maxArray[i] = maxArray[i+1];
            }else{
                maxArray[i] =prices[i];
            }
        }
        
        for(int i=0;i<n;i++){
            
            max=Math.max(max,maxArray[i] -prices[i]);
        }
        
        return max;
        
    }

	public static void main(String[] args) {
		int arr[] = {7,1,5,3,6,4};
		
		System.out.println(maxProfit(arr));

	}

}
