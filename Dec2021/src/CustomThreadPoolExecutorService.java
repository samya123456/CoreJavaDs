import java.util.LinkedList;
import java.util.Queue;

public class CustomThreadPoolExecutorService {

	private static CustomThreadClass[] threadpool;
	private static int size;
	private static CustomThreadPoolExecutorService service;
	private static Queue<Runnable> taskpool = new LinkedList<Runnable>();
	private static final Object key = new Object();

	public static CustomThreadPoolExecutorService newFixedThreadPoolExecutor(int n) {
		size = n;
		if (service == null) {
			service = new CustomThreadPoolExecutorService();
		}
		return service;
	}
	
	public void addTasks(Runnable r) {
		synchronized(key) {
			taskpool.add(r);
			key.notifyAll();
		}
	}

	private CustomThreadPoolExecutorService() {
		for (int i = 0; i < size; i++) {
			threadpool[i] = new CustomThreadClass();
			threadpool[i].start();
		}
	}
	
	

	private static class CustomThreadClass extends Thread {
		@Override
		public void run() {
			Runnable r;
			synchronized (key) {
				while (taskpool.isEmpty()) {
					try {
						key.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				r = taskpool.poll();
				r.run();
				key.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
