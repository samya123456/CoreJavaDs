package apple.com;

public class CuttingRod {
	
	public static int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[] = new int[n+1];
       for(int i=0;i<n+1;i++){
           dp[i] = -1;
       }
       
       dp[0] =0;
       
       for(int i=0;i<=n;i++){
           
           if(dp[i]!=-1){
               if(i+x<=n){
                   dp[i+x] = Math.max(dp[i+x],dp[i]+1);
               }
               if(i+y<=n){
                   dp[i+y] = Math.max(dp[i+y],dp[i]+1);
               }
               if(i+z<=n){
                   dp[i+z] = Math.max(dp[i+z],dp[i]+1);
               }
           }
       }
       
       if(dp[n]==-1){
           return 0;
       }
       
       return dp[n];
    }

	public static void main(String[] args) {
		
     System.out.println(maximizeCuts(6,2,4,3));
	}

}
