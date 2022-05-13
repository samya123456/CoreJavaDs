package com.leetcode;

public class Test {
	
	static class A{
		A(){
			System.out.println(this.getClass().getName());
		}
	}
	
	static class B extends A{
		B(){
			System.out.println(this.getClass().getName());
		}
	}

	public static void main(String[] args) {
		A a = new B();
	}

}
