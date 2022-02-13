package com.example.keep;

public class TestClass {
	

	public static void main(String[] args) {

		Thread t = new MyThread() {
			@Override
			public void run() {
				System.out.println("Hi");
			}
		};
		t.start();
		

	}

}
