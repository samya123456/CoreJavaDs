package google.com;

import java.util.*;

public class GenerateParentheses {
	
	  public static List<String> generateParenthesis(int n) {
	       List<String> op = new ArrayList<String>();
	       backtrack(op,"",0,0,n);
	       return op;
	    }

	private static void backtrack(List<String> op, String currentString, int open, int close, int max) {
		if(currentString.length()==max*2) {
			op.add(currentString);
			return ;
		}
		
		if(open<max) backtrack(op,currentString+"(",open+1,close,max);
		if(close<open) backtrack(op,currentString+")",open,close+1,max);
		
		
	}

	public static void main(String[] args) {
		List<String> op=generateParenthesis(3);
		for(String s: op) {
			System.out.println(s);
		}

	}

}
