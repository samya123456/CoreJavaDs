package google.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {

	public static String removeDuplicateLetters(String s) {

		char[] arr = s.toCharArray();
		
		StringBuffer op = new StringBuffer("");
		Stack<Character> st = new Stack();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
 
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int val = map.get(arr[i]);
				map.put(arr[i], val + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			
			if (!st.contains(arr[i])) {
				if (st.isEmpty()) {
					st.add(arr[i]);
					int val = map.get(arr[i]);
					map.put(arr[i], val - 1);
				} else {
					if (st.peek() < arr[i]) 
					{
						st.add(arr[i]);
						int val = map.get(arr[i]);
						map.put(arr[i], val - 1);
						
					}else {
						int val = map.get(st.peek());
						if (val > 0) {
							st.pop();
						}
					}
						

						
					
				}
			}

		}
		
		
		for(int i=0;i<st.size();i++) {
			op.append(st.get(i));
		}
		
		return op.toString();
		

	}

	public static void main(String[] args) {
		// System.out.println('a' > 'b');
		// System.out.println(((int) 'a')-97);
		System.out.println(removeDuplicateLetters("bcabc"));
	}

}
