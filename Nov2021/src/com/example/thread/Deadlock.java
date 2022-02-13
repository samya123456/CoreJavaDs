package com.example.thread;

public class Deadlock {

	private static Object key1 = new Object();
	private static Object key2 = new Object();

	public void a() {
		synchronized (key1) { 
			System.out.println("Thread " + Thread.currentThread().getName() +  " in method a");
			b();
		}
	}
	
	public void b() {
		synchronized (key2) {
			System.out.println("Thread " + Thread.currentThread().getName() + " in method b");
			c();
		}
	}
	
	public void c() {
		synchronized (key1) {
			System.out.println("Thread " + Thread.currentThread().getName() + " in method c");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Deadlock deadlock = new Deadlock();
		Runnable r1 = ()->{
			deadlock.a();
		};
		Runnable r2 = ()->{
			deadlock.b();
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
