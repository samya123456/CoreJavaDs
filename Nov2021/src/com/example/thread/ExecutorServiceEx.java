package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
	
		
	/*	Runnable r1 =()->{
			System.out.println("I'm in Thread "+ Thread.currentThread().getName());
		};
		
		ExecutorService service = 	Executors.newFixedThreadPool(4);
		
		for(int i=0;i<10;i++) {
			service.execute(r1);
		}
		
		service.shutdown(); */
		
		Callable<String> c =()->{
			Thread.sleep(300);
			return "I'm in Thread "+ Thread.currentThread().getName();
		};
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(int i=0;i<10;i++) {
			Future<String> op =service.submit(c);
			System.out.println(op.get(100,TimeUnit.MILLISECONDS));
		}
		
		service.shutdown();
		
		
		

	}
	
	

}
