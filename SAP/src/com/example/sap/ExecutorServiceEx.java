package com.example.sap;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx {
	
	
	public static void main(String[] a) throws InterruptedException, ExecutionException {
		Runnable r = ()-> System.out.println("I'm running " + Thread.currentThread().getName());
		
		Callable<String> c =() ->{
			return Thread.currentThread().getName();
			
		};
		Future<String> f;
		ExecutorService executor = Executors.newFixedThreadPool(4);
		for(int i=0;i<10;i++) {
			//executor.execute(r);
			
			f = executor.submit(c);
			
			System.out.println(f.get());
			
		}
		
		executor.shutdown();
		
		
		
		
	}

}
