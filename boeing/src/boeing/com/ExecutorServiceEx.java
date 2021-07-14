package boeing.com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		

		ExecutorService executors = Executors.newFixedThreadPool(8);
		
		Callable<String> c = ()->{
			return "I get"+ Thread.currentThread().getName();
		};
		
		Runnable r = () -> {
			System.out.println(Thread.currentThread().getName());

		};
		for (int i = 0; i < 10; i++) {
			Future<String> s = executors.submit(c);
			System.out.println(s.get());
		}
		executors.shutdown();
	}

}
