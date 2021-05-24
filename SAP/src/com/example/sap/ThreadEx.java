package com.example.sap;

public class ThreadEx {
	int i=1;
	int n=10;
	private static Object key = new Object();
	public void printEven()  {
		
			
			synchronized(key) {
				while(i<n) {
					if(i%2==1) {
						try {
							key.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
					System.out.println(i);
					i++;
					key.notify();
				}
				
				
				
				
			}
			
		}
	}
	
	
	public void printOdd() {
		
			synchronized(key) {
				while(i<n) {
				if(i%2==0) {
					try {
						key.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(i);
				i++;
				key.notify();
				
				}
				
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadEx threadEx = new ThreadEx();
		
		Runnable r1 = ()->{
				threadEx.printEven();
		};
		
		Runnable r2 = ()->{
		
				threadEx.printOdd();
			
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		


	}

}
