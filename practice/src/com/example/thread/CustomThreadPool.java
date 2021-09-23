package com.example.thread;

import java.util.LinkedList;

public class CustomThreadPool {
	
	private static final Object key =new Object();
	private static CustomThreadClazz[] threadpool;
	private static int size;
	private static CustomThreadPool instance;
	private static boolean isShutdown=false;
	private static LinkedList<Runnable> tasks = new LinkedList<>();
	
	
	public static CustomThreadPool newFixedThreadpool(int n) {
		size=n;
		threadpool = new CustomThreadClazz[size];
		if (instance==null) {
			instance = new CustomThreadPool();
		}
		return instance;
		
	}
	
	private CustomThreadPool(){
		for(int i= 0;i<size;i++) {
			threadpool[i] = new CustomThreadClazz();
		}
		
	}
	
	public void execute() {
		for(int i= 0;i<size;i++) {
			threadpool[i].start();
		}
	}
	
	public void shutdown() {
		isShutdown = true;
	}
	
	
	public void addTasks(Runnable r) {
		
		synchronized(key) {
			tasks.add(r);
			key.notifyAll();
		}
		
	}
	
	
	private static class CustomThreadClazz extends Thread{
		
		public void run() {
			
			while(!isShutdown) {
				
				synchronized(key) {
					while(tasks.isEmpty()) {
						try {
							key.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					Runnable r = tasks.poll();
					r.run();
					key.notifyAll();
				}
				
			}
			
		}
	}

	public static void main(String[] args) {

		CustomThreadPool customThreadPool = CustomThreadPool.newFixedThreadpool(4);
		Runnable r = () ->{
			System.out.println("Hi " + Thread.currentThread().getName());
		} ;
		
		for(int i =0;i<10;i++) {
			tasks.add(r);
		}
		
		customThreadPool.execute();
		customThreadPool.shutdown();

	}

}
