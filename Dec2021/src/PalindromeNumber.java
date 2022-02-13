
public class PalindromeNumber {
	
	 public static boolean isPalindrome(int x) {
	        
	        if(x==0){
	            return true;
	        }
	        if(x<0 || (x%10)==0){
	            return false;
	        }
	        int reverse_int = 0;
	        
	        while(x>reverse_int){
	            reverse_int =reverse_int*10 +(x%10);
	            x /=10;
	        }
	        
	        if(x==reverse_int || x ==reverse_int/10){
	            return true;
	        } else{
	            return false;
	        }
	        
	    }

	public static void main(String[] args) {
		isPalindrome(121);

	}

}
