package com.example.sap;

public class RaceConditionClassEx {

	public static void main(String[] args) throws InterruptedException {
		
		LongWrapper longWrapper = new LongWrapper(0l);
		
		Runnable r = () ->{
			for(int i=0;i<1000;i++) {
				longWrapper.incrementLong();
			}
		};
		
		Thread[] t = new Thread[1000];
		
		for(int i =0;i<1000;i++) {
			t[i] = new Thread(r);
			t[i].start();
		}
		
		for(int i=0;i<1000;i++) {
			t[i].join();
		}
		
		System.out.println(longWrapper.getValue());

	}

}
