
public class PowXn {
	
	 public static  double myPow(double x, int n) {
		 long nn = n;
		 if(n<0) {
			 nn = -1*nn;
		 }
	    
	     double ans =1;
	     while(nn>0) {
	    	 if(nn%2==1) {
	    		 ans = ans *x;
	    		 nn =nn-1;
	    	 }else {
	    		 x =x*x;
	    		 nn =nn/2;
	    	 }
	     }
	     return ans;
	        
	    }

	public static void main(String[] args) {

System.out.println(myPow(2,-2147483648));

	}

}
