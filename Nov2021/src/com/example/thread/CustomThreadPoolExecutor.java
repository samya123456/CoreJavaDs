package com.example.thread;

import java.util.LinkedList;

public class CustomThreadPoolExecutor {

	private static int size;
	static CustomThreadClazz threadpool[];
	static LinkedList<Runnable> taskpool = new LinkedList<Runnable>();
	private static final Object key = new Object();
	private static CustomThreadPoolExecutor instance;
	private static boolean isInterrupted = false;

	public static CustomThreadPoolExecutor newFixedThreadpool(int n) {
		size = n;
		if (instance == null) {
			instance = new CustomThreadPoolExecutor();
		}
		return instance;
	}

	private CustomThreadPoolExecutor() {
		

		
	}
	
	public static void submit() throws InterruptedException {
		threadpool = new CustomThreadClazz[size];
		for (int i = 0; i < size; i++) {
			threadpool[i] = new CustomThreadClazz();
			threadpool[i].start();
		}
		
		
	}
	
	public void addTask(Runnable r) {
		
		synchronized(key) {
			taskpool.addLast(r);
			key.notifyAll();
		}
	}

	static class CustomThreadClazz extends Thread {
		@Override
		public void run() {
			Runnable r;
			while (!isInterrupted) {
				synchronized (key) {
					while (taskpool.isEmpty()) {
						try {
							key.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					r = taskpool.removeFirst();
					r.run();
					key.notifyAll();
				}
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {
		instance  = CustomThreadPoolExecutor.newFixedThreadpool(4);
		CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor();
		
		Runnable r =()->{
			System.out.println("Thread name ="+ Thread.currentThread().getName());
		};
		
		for(int i =0 ;i<10;i++) {
			customThreadPoolExecutor.addTask(r);
		}
		instance.submit();
		instance.isInterrupted =true;

	}

}
