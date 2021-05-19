package payPal.thread;

import java.util.LinkedList;

public class CustomThreadPoolExe {
	private static  int size;
	static CustomThreadClazz[] threadpool;
	static LinkedList<Runnable> tasks;
	private static CustomThreadPoolExe instance;
	public static CustomThreadPoolExe newFixedThreadPoolExe(int n) {
		
		size =n;
		if (instance==null) {
			instance = new CustomThreadPoolExe();
		}
		
		return instance;
	}
	
	private CustomThreadPoolExe() {
		threadpool = new CustomThreadClazz[size];
		tasks = new LinkedList<Runnable>();
		for(int i=0;i<size;i++) {
			threadpool[i] =  new CustomThreadClazz();
			
		}
	}
	
	public void execute() {
		for(int i=0;i<size;i++) {
			threadpool[i].setName("Thread-"+i);;
			threadpool[i].start();
		}
	}
	
	public void enQueueTask(Runnable r) {
		synchronized(tasks) {
			tasks.addLast(r);
			tasks.notify();
		}
	}
	
	private static class CustomThreadClazz extends Thread{
		
		
		public void run() {
			Runnable r;
			while(true) {
				synchronized(tasks) {
					if(tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					r= tasks.removeFirst();
					r.run();
					tasks.notify();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		CustomThreadPoolExe customThreadPoolExe = CustomThreadPoolExe.newFixedThreadPoolExe(4);
		Runnable r =()->{
			System.out.println("Thread name " + Thread.currentThread().getName());
		};
		for(int i=0;i<10;i++) {
			customThreadPoolExe.enQueueTask(r);
		}
		
		customThreadPoolExe.execute();

	}

}
