import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParenthesis {
	public boolean isValid(String s) {

		Stack<Character> q = new Stack<Character>();
		char ch;
		for (int i = 0; i < s.length(); i++) {

			if (isOpposite(s.charAt(i))) {
				ch = q.pop();
				if (s.charAt(i) == findOpposite(ch)) {
					continue;
				} else {
					return false;
				}
			} else {
				q.add(s.charAt(i));

			}

		}

		return q.isEmpty();

	}

	private boolean isOpposite(char ch) {
		if (ch == ')' || ch == '}' || ch == ']') {
			return true;
		}

		return false;
	}

	private char findOpposite(char ch) {
		if (ch == '(')
			return ')';
		if (ch == '{')
			return '}';
		if (ch == '[')
			return ']';
		return ' ';
	}

	public static void main(String[] args) {
		String str ="([)]";
		
		new ValidParenthesis().isValid(str);

	}

}
