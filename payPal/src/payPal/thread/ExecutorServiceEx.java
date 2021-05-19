package payPal.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		Runnable r = ()->{
			System.out.println("Thread name=" + Thread.currentThread().getName());
		};
		
		
		Callable<String> c =()->{
			
			Thread.sleep(300);
			
			return "Thread name=" + Thread.currentThread().getName();
		};
		for(int i=0;i<10;i++) {
			Future<String> f =executor.submit(c);
			System.out.println(f.get());
		}
		
		
		executor.shutdown();

	}

}
