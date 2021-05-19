package com.example;

import java.util.*;

public class CustomExecutorService {

	
	static int size;
	CustomThreadClazz[] threadpool;
	LinkedList<Runnable> taskpool;
	static CustomExecutorService executorService;
	
	static CustomExecutorService fixedSizeThreadPool(int n) {
		size=n;
		if(executorService==null) {
			executorService = new CustomExecutorService();
		}
		return executorService;
	}
	
	public void enQueueTaske(Runnable r) {
		synchronized(taskpool) {
			taskpool.addLast(r);
			taskpool.notify();
		}
	}
	
	
	private CustomExecutorService() {
		for(int i=0;i<size;i++) {
			threadpool[i] = new CustomThreadClazz();
			threadpool[i].start();
		}
		
	}
	public class CustomThreadClazz extends Thread{
		@Override
		public void run() {
			Runnable r;
			while(true) {
				synchronized(taskpool) {
					while(taskpool.isEmpty()) {
						try {
							taskpool.wait();
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					}
				}
				r= taskpool.removeFirst();
				r.run();
			}
		}
	}
	public static void main(String[] args) {
		

	}


}
