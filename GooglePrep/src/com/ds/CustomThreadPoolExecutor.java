package com.ds;

import java.util.LinkedList;

public class CustomThreadPoolExecutor {
	
	private static LinkedList<Runnable> taskPool = new  LinkedList<Runnable>();
	private static CustomThreadClazz[] threadPool;
	private static final Object key = new Object();
	private static int size;
	private static CustomThreadPoolExecutor instance;
	private static  boolean  isShutDown;
	
	public static CustomThreadPoolExecutor newFixedSizePool(int n) {
		size =n;
		
		if(instance==null) {
			instance =new  CustomThreadPoolExecutor();
		}
		return instance;
	}
	
	private CustomThreadPoolExecutor() {
		threadPool = new CustomThreadClazz[size];
		for(int i=0;i<size;i++) {
			threadPool[i] =  new CustomThreadClazz(); 
			threadPool[i].start();
		}
	}
	public void addTask(Runnable r) {
		synchronized(key) {
			taskPool.addLast(r);
			key.notifyAll();
		}
	}
	private static class CustomThreadClazz extends Thread {
		
		@Override
		public void run() {
			while(!isShutDown) {
				 
				synchronized(key) {
					while(taskPool.isEmpty()) {
						try {
							key.wait();
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					}
					
					Runnable r = taskPool.pollFirst();
					r.run();
					key.notifyAll();
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
