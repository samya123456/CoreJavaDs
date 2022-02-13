import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParemThesis {

	public static boolean validParenthesis(String parenthesis) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < parenthesis.length(); i++) {
			char ch = parenthesis.charAt(i);

			if (isOpposite(ch)) {
				if (stack.isEmpty()) {
					return false;
				} else {
					char temp = stack.peek();
					if (Opposite(temp) == ch) {
						stack.pop();
					} else {
						return false;
					}
				}
			} else {
				stack.add(ch);
			}
		}

		return stack.isEmpty();
	}

	private static char Opposite(char temp) {
		if (temp == '(') {
			return ')';
		}
		if (temp == '{') {
			return '}';
		}
		if (temp == '[') {
			return ']';
		}

		return 0;
	}

	private static boolean isOpposite(char ch) {
		if (ch == ')' || ch == '}' || ch == ']') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(validParenthesis("({[)]})"));

	}

}
