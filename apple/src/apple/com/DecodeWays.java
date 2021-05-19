package apple.com;

public class DecodeWays {
	
   public static int numDecodings(String s) {
	   
	   int[] dw = new int[s.length()+1];
	   dw[0]=1;
	   dw[1] = s.charAt(0) =='0'?0:1;  
	   for(int i=2;i<=s.length();i++) {
		   int oneDigit = (s.charAt(i-1)-'0');
		   int twoDigits = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
		   
		   if(oneDigit>=1) {
			   dw[i] += dw[i-1];
		   }
		   
		   if(twoDigits>=10 && twoDigits<=26) {
			   dw[i] += dw[i-2];
		   }
	   }
	   
	   return  dw[s.length()];
        
    }

	public static void main(String[] args) {
		System.out.println(numDecodings("226"));;

	}

}
