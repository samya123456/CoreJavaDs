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

		  Runnable r1 = ()->{
			System.out.println("I'm in Thread "+ Thread.currentThread().getName() );  
		  };
		  
		  ExecutorService executor = Executors.newFixedThreadPool(4);
		  
		  
		  Callable<String> task =()->{
			  Thread.sleep(200);
			  return "I'm in Thread==" + Thread.currentThread().getName();
			  
		  };
		  
		  for(int i=0;i<10;i++) {
			 // new Thread(r1).start();
			  
			  try {
			  Future<String> future =executor.submit(task);
			  System.out.println(future.get(100,TimeUnit.MILLISECONDS));
			  }finally {
				  executor.shutdown();
		  }
		  }
		 

	}

}
