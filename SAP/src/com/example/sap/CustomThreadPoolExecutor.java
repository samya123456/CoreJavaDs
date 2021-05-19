package com.example.sap;

import java.util.LinkedList;

public class CustomThreadPoolExecutor {

	private static CustomThreadClass[] threadpool;
	private static LinkedList<Runnable> tasks;
	private static boolean shutdownFlag = false;
	private final static Object key= new Object();
	
	private static CustomThreadPoolExecutor instance;

	public static boolean shutdown() {
		shutdownFlag = true;
		return shutdownFlag;
	}

	public static CustomThreadPoolExecutor newFixThreadPoolExecutor(int n) {
		synchronized(key) {
		threadpool = new CustomThreadClass[n];
		tasks = new LinkedList<Runnable>();
		for (int i = 0; i < threadpool.length; i++) {
			threadpool[i] = new CustomThreadClass();
			threadpool[i].start();
		}
		
		if (instance== null) {
			return new CustomThreadPoolExecutor();
		}
		
		return instance;
		}
	}
	
	private CustomThreadPoolExecutor(){
		
	}

	public static void execute(Runnable r) throws InterruptedException {

		synchronized (tasks) {
			if(tasks.size()>=10) {
				tasks.wait();
			}
				tasks.addLast(r);
				tasks.notifyAll();
			
			
		}
	}

	private static class CustomThreadClass extends Thread {

		@Override
		public void run() {

			while (!shutdownFlag ) {
				synchronized (tasks) {
					if (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
						Runnable r = tasks.removeFirst();
						r.run();
					
					
				}
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		CustomThreadPoolExecutor  customThreadPoolExecutor = CustomThreadPoolExecutor.newFixThreadPoolExecutor(4);
		
		
		Runnable r =()->{
			System.out.println("Im in Thread==="+ Thread.currentThread().getName());
		};
		
		
		for (int i=0;i<10;i++) {
			customThreadPoolExecutor.execute(r);
		}
		customThreadPoolExecutor.shutdown();
		

	}

}
