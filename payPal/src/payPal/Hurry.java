package payPal;

public class Hurry {
	
	 static int solve(int n, int t, int[][] task){
	       int start =0;
	       int count =1;
	       int totaltime = 0;
	       int remainingTime = 0;
	       for(int i=0;i<task.length;i++){
	           int pos = task[i][0];
	           int time = task[i][1];
	           totaltime = totaltime +Math.abs((start-pos)) + time;
	           start = pos;
	           remainingTime = t -totaltime;
	           if(remainingTime<0) {
	        	   return count;
	           }
	           if(pos+remainingTime<=t){
	               count++;
	           }
	           
	       }
	       return count;
	    
	    }

	public static void main(String[] args) {
		int n =3;
		int t = 16	;
		int[][] tasks = {{2,8},{4,5},{5,1}};
		
		System.out.println(solve(n,t,tasks));

	}

}
