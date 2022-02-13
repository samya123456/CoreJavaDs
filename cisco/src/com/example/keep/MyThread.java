package com.example.keep;

public class MyThread extends Thread {
	
	MyThread(){
		System.out.println("MyThread");
	}

	@Override
	public void run() {
		System.out.println("run");
	}

	

}
