package com.pega;


public class OverrideFinal {
	
	class A {
		final Integer value =10;
		public   void doing() {
			System.out.println("A");
		}
		
	}
	
	 class B extends A{
		final Integer value =15;
		public   void doing() {
			System.out.println("B");
		}
		
	 }
	public static void main(String[] args) {
	/*	 Queue<Character> q = new LinkedList<Character>();
		OverrideFinal overrideFinal = new OverrideFinal();
		B a = overrideFinal.new B();
		System.out.println(a.value);
		a.doing(); */
		System.out.println((char)89);
		
	}

}
