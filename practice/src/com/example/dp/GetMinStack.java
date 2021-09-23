package com.example.dp;

import java.util.Stack;

public class GetMinStack {
	
	private static int min;
	private static Stack<Integer> originalStack = new Stack<Integer>();
	
	public static int getMin() {
		return min;
	}
	
	public static void push(int element) {
		if(originalStack.isEmpty()) {
			originalStack.push(element);
			min=element;
		}else if(element>=min) {
			originalStack.push(element);
		}else {
			originalStack.push(2*element-min);
			min =element;
		}
	}
	
	public static void pop() {
		if(originalStack.isEmpty()) {
			return;
		}else if(originalStack.peek()>min) {
			originalStack.pop();
		}else {
			min = 2*min - originalStack.peek();
			originalStack.remove(originalStack.peek());
		}
	}

	public static void main(String[] args) {
			push(5);
			push(3);
			push(1);
			System.out.println(getMin());
			pop();
			System.out.println(getMin());
			push(2);
			System.out.println(getMin());
			pop();
			System.out.println(getMin());

	}

}
