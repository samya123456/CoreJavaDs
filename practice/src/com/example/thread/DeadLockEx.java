package com.example.thread;

public class DeadLockEx {
	
	private static final Object key1 = new Object();
	private static final Object key2 = new Object();

	public void a() {
		synchronized(key1) {
			System.out.println("I'm in a ");
			b();
		}
		
		
	}
	
	public void b() {
		synchronized(key2) {
			System.out.println("I'm in b ");
			c();
		}
		
	}
	
	public void c() {
		synchronized(key1) {
			System.out.println("I'm in c ");
			
		}
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		DeadLockEx deadLockEx = new DeadLockEx();
		
		
		Runnable r1 = ()->{
			deadLockEx.a();
		};
		
		Runnable r2 = ()->{
			deadLockEx.b();
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();

	}

}
