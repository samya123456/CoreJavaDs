package google.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		 int n = s.length();
	        int l =0;
	        int r =1;
	        Set<Character> st = new LinkedHashSet<Character>();
	        st.add(s.charAt(0));
	        int len =1;
	        while(r<n){
	            if(!st.contains(s.charAt(r))){
	                st.add(s.charAt(r));
	                r++;
	            }else{
	                st.remove(s.charAt(l));
	                l++;
	            }
	            
	            if(len<(r-l)) {
	            	len = (r-l);
	            }
	        }
	        return len;
	}

	public static void main(String[] args) {
		String  s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));

	}

}
