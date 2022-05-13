package com.ds;

public class OddEvenThread {
	
	
	private static final Object key = new Object();
	
	int i =1;
	int n=10;
	
	
	public void printEven() throws InterruptedException {
		
		while(i<n) {
			synchronized(key) {
				if(i%2==1) {
					key.wait();
				}
				System.out.println("Thread name =" +Thread.currentThread().getName() + "Number ="+i);
				i++;
				key.notify();
			}
		}
	}
	
  public void printOdd() throws InterruptedException {
		
		while(i<n) {
			synchronized(key) {
				if(i%2==0) {
					key.wait();
				}
				System.out.println("Thread name =" +Thread.currentThread().getName() + " Number ="+i);
				i++;
				key.notify();
			}
		}
	}

	public static void main(String[] args) {
		
		OddEvenThread oddEvenThread = new OddEvenThread();
		Runnable even =()->{
			try {
				oddEvenThread.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable odd =() ->{
			
			try {
				oddEvenThread.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread oddT = new Thread(odd);
		oddT.setName("Odd Thread");
		Thread evenT = new Thread(even);
		evenT.setName("Even Thread");
		oddT.start();
		evenT.start();

	}

}
