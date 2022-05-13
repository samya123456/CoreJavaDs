package com.ds;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		
		Callable<String> task2 = ()->{
			return "Thread name==" + Thread.currentThread().getName(); 
		};
		
		
		for(int i=0;i<10;i++) {
			Future<String> future = service.submit(task2);
			System.out.println(future.get());
		}
		
		service.shutdown();
		

	}

}
