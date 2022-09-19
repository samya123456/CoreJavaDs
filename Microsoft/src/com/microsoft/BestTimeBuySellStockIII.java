package com.microsoft;

public class BestTimeBuySellStockIII {
	
	 public int maxProfit(int[] prices) {
	       int fb = Integer.MIN_VALUE;
	       int sb = Integer.MIN_VALUE;
	       int fs = 0;
	       int ss = 0;
	        
	        for(int i =0;i<prices.length;i++){
	            fb = Math.max(fb , -prices[i]);
	            fs = Math.max(fs, fb+ prices[i]);
	            sb = Math.max(sb , fs - prices[i]);
	            ss = Math.max(ss, sb + prices[i]);
	        }
	        
	        return ss;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
