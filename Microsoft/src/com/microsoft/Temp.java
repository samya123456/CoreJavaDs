package com.microsoft;

public class Temp {
	
	  public static  boolean rotateString(String s, String goal) {
	         String newString  = s;
	         int n = s.length();
	        for(int i =1;i<n;i++){
	           newString = newString.substring(1,n) +  newString.charAt(0);
	           if(newString.equals(goal)){
	               return true;
	           }
	        }
	        
	        return false;
	    }

	public static void main(String[] args) {

		String s = "abcde";
		String goal = "cdeab";
			System.out.println(rotateString(s,goal));

	}

}
