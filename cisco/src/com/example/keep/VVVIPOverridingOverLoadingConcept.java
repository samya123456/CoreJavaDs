package com.example.keep;


public class VVVIPOverridingOverLoadingConcept {
	
	static class A {
		void m(String s) {
			System.out.println("A->m");
		}
		void a() {
			System.out.println("A->a");
		}
	}
	
	static class B extends A {
		void m(Object o) {
			System.out.println("B->m");
		}
		
		void b() {
			System.out.println("B->b");
		}
	}

	
	public static void main(String[] args) {
		B b = new B();
		b.m(null); //overriding ->overloading ->overriding
		
		A a = new B();
		a.m(null); //overriding ->overloading ->overriding
	}

}
