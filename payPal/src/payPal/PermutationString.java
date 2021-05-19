package payPal;

import java.util.*;

public class PermutationString {
	
	static Set<String> hs = new HashSet<String>();
	private static void permutaStringUtil(String input , String ans) {
		if (input.length()==0) {
			hs.add(ans);
			return;
		}
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			
			String ros = input.substring(0,i) + input.substring(i+1);
			permutaStringUtil(ros,ans+ch);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutaStringUtil("abc","");
		
		for(String s: hs) {
			System.out.println(s);
		}

	}

}
