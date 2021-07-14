package com.example.keep;

import java.util.Stack;

public class StackImpl {
	Stack<Integer> st = new Stack<Integer>();
	int min = Integer.MIN_VALUE;

	public void push(int val) {
		if (st.isEmpty()) {
			st.push(val);
			min=val;
		} else if (val >= min) {
			st.push(val);
		} else {
			st.push(2 * val - min);
			min = val;
		}
	}

	public void pop() {
		if (st.isEmpty()) {
			return;
		} else if (st.peek() >= min) {
			st.pop();
		} else {
			min = 2 * min - st.peek();
			st.pop();
		}
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		
		StackImpl minStack = new StackImpl();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);
		minStack.top(); 
		minStack.pop();
		minStack.getMin(); // return -3
		minStack.pop(); // return 0
		minStack.getMin();
		minStack.pop();
		minStack.push(2147483647);
		minStack.top();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();// return -2

	}

}
