import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceEx {

	public static void main(String[] args) {
		//Runnable r1 =()->System.out.println(Thread.currentThread().getName());
		
		Callable<String> task= ()->{
			Thread.sleep(290);
			return Thread.currentThread().getName();
			
		};
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		for(int i=0;i<10;i++) {
			
			Future<String> op =service.submit(task);
			try {
				try {
					System.out.println(op.get(300,TimeUnit.MILLISECONDS));
				} catch (TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		service.shutdown();

	}

}
