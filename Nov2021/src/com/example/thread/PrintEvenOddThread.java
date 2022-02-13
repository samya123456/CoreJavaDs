package com.example.thread;

public class PrintEvenOddThread {
	
	public static int i=1;
	public static int n=10;
	private static final Object key = new Object();
	
	static class PrintEven{
		public void printEven() throws InterruptedException {
			synchronized(key) {
			while(i<n) {
				if(i%2!=0) {
					key.wait();
				}
					System.out.println("Thead= " +Thread.currentThread().getName()+" i="   +  i);
					i++;
					key.notify();
				}
			}
		}
	}
	
	static class PrintOdd{
		public void printOdd() throws InterruptedException {
			synchronized(key) {
			while(i<n) {
				if(i%2!=1) {
					key.wait();
				}
					System.out.println("Thead= " +Thread.currentThread().getName()+" i="   +  i);
					i++;
					key.notify();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PrintEven even = new PrintEven();
		PrintOdd odd = new PrintOdd();
		Runnable oddRunnable =()->{
			try {
				odd.printOdd();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable evenRunnable =()->{
			try {
				even.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread evenThread = new Thread(evenRunnable,"Even Thread");
		Thread OddThread = new Thread(oddRunnable,"odd Thread");
		evenThread.start();
		OddThread.start();
		evenThread.join();
		OddThread.join();

	}

}
