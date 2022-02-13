package com.example.thread;

public class RaceConditions {

	public static void main(String[] args) throws InterruptedException {
		
		LongWrapper longWrapper = new LongWrapper();
		Thread pool[] = new Thread[1000];
		Runnable r =()->{
			for(int i =1;i<=1000;i++) {
				longWrapper.incrementValue();
			}
		};
		for(int i=0;i<1000;i++) {
			pool[i] = new Thread(r);
			pool[i].start();
		}
		
		for(int i=0;i<1000;i++) {
			
			pool[i].join();
		}
		
		
		System.out.println(longWrapper.getLong());
		

	}

}
