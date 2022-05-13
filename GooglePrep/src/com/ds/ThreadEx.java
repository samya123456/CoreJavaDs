package com.ds;

public class ThreadEx {

	public static void main(String[] args) throws InterruptedException {
		
		
		LongWrapper longWrapper = new LongWrapper();
		Runnable r =()->{
			for(int i=0;i<1_000;i++) {
				longWrapper.incrementValue();
			}
			
		};
		
		
		Thread[] pool = new Thread[1000];
		for(int i=0;i<1_000;i++) {
			Thread t = new Thread(r);
			pool[i] =t;
			pool[i].start();
		}
		
		for(int i=0;i<1_000;i++) {
			pool[i].join();
		}
		
		System.out.println(longWrapper.getLong());
			
			
			
	}

}
