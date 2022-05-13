package cisco.com.example;

import java.util.Stack;

public class LongestValidParentheses {
	
	public static int maxBalancedParenthesis(String input) {
		
		Stack<Integer> st = new Stack<>();
		int maxValid =0;
		st.push(-1);
		for(int i =0;i<input.length();i++) {
			if(input.charAt(i)=='(') {
				st.push(i);
			}else {
				st.pop();
				if(st.isEmpty()) {
					st.push(i);
				}else {
					maxValid = Math.max(maxValid, i - st.peek());
				}
			}
		}
		return maxValid;
		
		
	}
	
public static int maxBalancedParenthesisApproach2(String input) {
		
		
		int maxValid =0;
		int open = 0;
		int closed =0;
		for(int i =0;i<input.length();i++) {
			if(input.charAt(i)=='(') {
				open++;
			}else {
				closed++;
			}
			if(open ==closed) {
				maxValid =Math.max(maxValid, 2*open);
			}else if(closed >open) {
				open =closed =0;
			}
			
		}
		
		open =0;
		closed =0;
		
		for(int i =input.length()-1;i>=0;i--) {
			if(input.charAt(i)=='(') {
				open++;
			}else {
				closed++;
			}
			if(open ==closed) {
				maxValid =Math.max(maxValid, 2*open);
			}else if(open >closed) {
				open =closed =0;
			}
			
		}
		return maxValid;
		
		
	}

	

	public static void main(String[] args) {
		String input =")()()(()"; //4
		
		System.out.println(maxBalancedParenthesisApproach2(input));

	}

}
