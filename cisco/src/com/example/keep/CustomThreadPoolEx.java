package com.example.keep;

import java.util.LinkedList;

public class CustomThreadPoolEx {
	static LinkedList<Runnable> taskpool  =new  LinkedList<Runnable>();
	CustomThreadcazz[] threadpool;
	 static int size;
	private final static Object key = new Object();
	private static CustomThreadPoolEx customThreadPoolEx;
	public static boolean isShutDown=false;
	public static CustomThreadPoolEx newFixedSizeThreadPool(int n) {
		size = n;
		if(customThreadPoolEx==null) {
			customThreadPoolEx = new CustomThreadPoolEx();
		}
		return customThreadPoolEx;
	}
	
	private CustomThreadPoolEx() {
		for(int i=0;i<size;i++) {
			threadpool[i] = new CustomThreadcazz();
			threadpool[i].start();
		}
	}
	public void addTasks(Runnable r) {
		synchronized(key) {
			taskpool.addLast(r);
			key.notifyAll();
		}
		
	}
	private static class CustomThreadcazz extends Thread{
		@Override
		public void run() {
			while(!isShutDown) {
				
				synchronized(key) {
					if(taskpool.isEmpty()) {
						try {
							key.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Runnable r = taskpool.poll();
					r.run();
					key.notify();
				}
			}
		}
	}
	

	public static void main(String[] args) {
		

	}

}
