package google.com;

import java.util.Arrays;

public class AmazonCodingTest3 {
	
	public int quality(int[] packets, int channels){
	    int n = packets.length;
	    if(n==channels) {
	        int sum = 0;
	        for(int packet : packets){
	            sum+=packet;
	        }
	        return sum;
	    }
	    Arrays.sort(packets);
	    double result = 0;
	    for(int i=n-channels+1;i<n;i++) result+=packets[i];
	    int m = n-channels+1;
	    if(m%2==1){
	      result+=packets[((m+1)/2)-1];
	    }
	    else{
	      double val= Math.ceil((double)(packets[((m+1)/2)-1]+packets[m/2])/2);
	      result = result+val;
	    }
	    return (int)result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
