
public class AddBinary {
	
	 public static String addBinary(String a, String b) {
	        StringBuilder br = new StringBuilder();
	        int i =a.length()-1;
	        int j =b.length()-1;
	        int carry =0;
	        
	        while(i>=0 || j>=0){
	            int sum =carry;
	            
	            if(i>=0){
	                sum += a.charAt(i--)-'0';
	            }
	            if(j>=0){
	                sum += b.charAt(j--)-'0';
	            }
	            
	            br.insert(0,sum%2);
	            carry =sum/2;
	        }
	        
	        if(carry>0){
	            br.insert(0,1);
	        }
	        
	        return br.toString();
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(addBinary("0","0"));

	}

}