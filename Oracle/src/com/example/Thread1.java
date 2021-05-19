package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class Thread1 {
	
	Queue<Thread> queue = new LinkedList<Thread>();
	public static Queue<Runnable> tasks = new LinkedList<Runnable>();
	int maxsize;
	
	public Thread1(int maxsize) {
		this.maxsize=maxsize;
	}
	Runnable task1 = ()->{
		System.out.println("I'm task 1");
	} ;
	
	public void createTasks() {
		tasks.add(task1);
		while(!tasks.isEmpty()) {
			Runnable temp = tasks.remove();
			createFixedSizeThreadPool(temp);
		}
	}
	
	public void createFixedSizeThreadPool(Runnable tasks) {
		
		
		if(queue.size()<maxsize) {
			queue.add(new Thread(tasks));
		}else {
			Thread t = queue.remove();
			queue.add(t);
		}
	}

	
	public void runTasks() {
		while(!queue.isEmpty()) {
			Thread t1 =queue.remove();
			t1.start();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
