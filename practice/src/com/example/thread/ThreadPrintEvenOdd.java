package com.example.thread;

public class ThreadPrintEvenOdd {
	
	private  int i=1;
	private  int n=10;
	private final static Object key = new Object(); 
	
	private void printEven() throws InterruptedException {
		synchronized(key) {
			while(i<n) {
				if(i%2==1) {
					key.wait();
				}
				System.out.println(Thread.currentThread().getName()+"  "+i);
				i++;
				key.notify();
			}
		}
	}
	
	private void printOdd() throws InterruptedException {
		synchronized(key) {
			while(i<n) {
				if(i%2==0) {
					key.wait();
				}
				System.out.println(Thread.currentThread().getName()+"  "+i);
				i++;
				key.notify();
			}
		}
	}
	

	public static void main(String[] args) {
		ThreadPrintEvenOdd threadPrintEvenOdd = new ThreadPrintEvenOdd();
		Runnable even =()->{
			try {
				threadPrintEvenOdd.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable odd =()->{
			try {
				threadPrintEvenOdd.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(even);
		Thread t2 = new Thread(odd);
		t1.setName("Even=");
		t2.setName("Odd=");
		t1.start();
		t2.start();

	}

}
