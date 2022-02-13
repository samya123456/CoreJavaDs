package google.com;

import java.util.Arrays;

public class BoatToSavePeople {
	
	public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); //1,2,2,3
        int count=0;
        int i=0;
        int j=1;
        int n = people.length;
        if(n==1) {
        	return 1;
        }
        while(j<n){
            if(people[i]+people[j]<=limit){
            	 count++;
                
            }else{
                count=count+2;
            }
            i=j+1;
            j=i+1;
        }
       if(j==n && i<n && people[i]<=limit) {
    	   count++;
       }
        return count;
        
    }

	public static void main(String[] args) {
		int[] people = {3,4,3,2};
		int limit =5;
				
		System.out.println(numRescueBoats(people,limit));

	}

}
