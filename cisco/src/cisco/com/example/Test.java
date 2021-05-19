package cisco.com.example;

public class Test {
	
	
	public String modifyString(String riddle) {
	    // write your code in Java SE 8
	    char[] input = riddle.toCharArray();
	    int n = input.length;
	    return generateString(input, n);
	}

	private String generateString(char[] input, int n){
	    for(int i=0; i< n; i++){
	        char c = input[i];
	        if(c == '?'){
	            replaceWithAlphabet(input, i, n);
	        }
	    }
	    return new String(input);
	}
	private void replaceWithAlphabet(char[] input, int i, int n){
	    if( i== 0){
	        if(i+1 == n){ // lenght 1
	            input[i] = 'a';
	        }else {
	            input[i] = getNextChar(input[i], input[i+1]);
	           
	        }
	    }else if ( i==n-1){ //last
	        input[i] = getNextChar(input[i-1], input[i-1]);
	    }else {
	    	if(input[i+1]=='?') {
	    		 input[i] = getNextChar(input[i-1], input[i+2]);
	    	}else {
	    		input[i] = getNextChar(input[i+1], input[i+1]);
	    	}
	        
	    }
	}
	private char getNextChar(char c1, char c2){
	    for(char c = 'a'; c <='z'; c++){
	        if(c != c1 && c!=c2) return c;
	    }
	    return 'a';
	}
	
	 public int[] twoSum(int[] numbers, int target) {
		 int[] op = new int[2];
	        int count = 1;
	        int sum =0;
	        int temp =0;
	        if(numbers.length==2){
	            op[0]=1;
	            op[1]=2;
	            return op;
	        }
	        for(int i =numbers.length-1;i>=0;i--){
	            if(numbers[i]>0 &&numbers[i]<=target-sum){
	                sum = sum + numbers[i];
	                op[count--] = i+1;
	                if(sum==target)
	                    break;
	            }
	            else if(numbers[i]<0) {
	            	temp = i+1;
	            	sum = numbers[i];
	            	break;
	            	
		        	
		        }
	            
	          
	        }
	        op[0] =temp;
        	for(int j=temp;j<numbers.length;j++) {
        		if(Math.abs(sum)==numbers[j]) {
        			op[1] = j+1;
        			return op;
        		}
        	}
	        
	        
	        
	        if(op[0]==0){
	            op[0] =1;
	        }
	        return op;
	    }
	 
	 public boolean isPowerOfTwo(int n) {
	        if(n==1)
	            return true;
	        while(n!=1)
	            if(n%2 ==0){
	                n=n/2;
	            }else{
	                return false;
	            }
	        
	        return false;
	    }

	public static void main(String[] args) {
		//System.out.println(new Test().modifyString("aa??aa"));;
		int[] ip = {0,0,3,4};
		new Test().isPowerOfTwo(16);
	}

}
