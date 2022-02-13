  package com.example.keep;

import java.util.Stack;

public class GetMinInO1timeO1Space {
	
	
	private static int min;
	
	static Stack<Integer> originalStack = new Stack<Integer>();
	
	public static int getMin() {
		return min;
	}
	
	public static void push(int element) {
		if(originalStack.isEmpty()) {
			originalStack.push(element);
			min= element;
		}else if(element>=min) {
			originalStack.push(element);
		}else {
			originalStack.push(2*element-min);
			min=element;
		}
	}
	
	public static void pop() {
		if(originalStack.isEmpty()) {
			return;
		}
		if(originalStack.peek()>min) {
			originalStack.pop();
		}else {
			min = 2*min -originalStack.peek();
			originalStack.pop();
		}
	}

	public static void main(String[] args) {
		push(3);
		push(6);
		push(1);
		
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		
	}

}
