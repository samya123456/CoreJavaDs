package com.example.dp;

public class InterfaceDefaultEx {
	
	
	interface I{
		default void show() {
			System.out.println("I");
		}
	}
	
	interface J{
		default void show() {
			System.out.println("J");
		}
	}
	
	class A implements I,J{

		
		public void show() {
		
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
