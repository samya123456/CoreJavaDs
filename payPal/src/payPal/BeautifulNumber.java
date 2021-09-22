package payPal;


	
	import java.io.*;
	import java.util.*;


	public class BeautifulNumber {
	 
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	        int T = Integer.parseInt(br.readLine().trim());
	        for(int t_i = 0; t_i < T; t_i++)
	        {
	            
	            String[] str = br.readLine().split(" ");
	            int l = Integer.parseInt(str[0]);
	            int r = Integer.parseInt(str[1]);

	            long out_ = solve(l, r,T);
	            System.out.println(out_);
	            
	         }

	         wr.close();
	         br.close();
	    }

	    static boolean isBeautiful(int n){
	     HashSet<Integer> seen = new HashSet<Integer>();
	        while(n!=1){
	            int current =n;
	            int sum =0;
	            while(current!=0){
	                sum += (current%10) * (current%10);
	                current /=10;
	            }
	            if(seen.contains(sum)){
	                return false;
	            }
	            seen.add(sum);
	            n=sum;
	        }
	        return true;
	    }

	    static boolean inLimit(long num){
	        if(num>=1 && num <= Math.pow(10,6)){
	            return true;
	        }

	        return false;
	    }
	    static long solve(int l, int r, int T){
	       
	       if(inLimit(l) && inLimit(r) && inLimit(T) && r>=l){
	           long sum =0;
	       for(int i=l ; i<=r;i++){
	           if(isBeautiful(i)){
	               sum +=i;
	           }
	       }

	       return sum;
	       }else{
	           return 0;
	       }
	       
	       
	    
	    }
	}


