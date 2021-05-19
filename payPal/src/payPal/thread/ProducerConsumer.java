package payPal.thread;

public class ProducerConsumer {
	
	
	static int[] buffer;
	private final static Object key = new Object();
	static int count;
	
	
	static class Producer{
		
		public void produce() throws InterruptedException {
			synchronized(key) {
				if(isFull(buffer)) {
					key.wait();
				}
				buffer[count++] =1;	
				
				key.notify();
			}
			
		}

		private boolean isFull(int[] buffer) {
			
			return buffer.length==count;
		}
		
	}

	
	static class Consumer{
		public void consumes() throws InterruptedException {
			synchronized(key) {
				if(isEmpty(buffer)) {
					key.wait();
				}
				buffer[--count] =0;	
				key.notify();
			}
			
		}

		private boolean isEmpty(int[] buffer) {
			return buffer.length==0;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		buffer = new int[50];
		count =0;
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Runnable prodRun =()->{
			for(int i=0;i<45;i++) {
				try {
					producer.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable conRun =()->{
			for(int i=0;i<50;i++) {
				try {
					consumer.consumes();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread prodThread = new Thread(prodRun);
		Thread conThread = new Thread(conRun);
		prodThread.start();
		conThread.start();
		
		prodThread.join();
		conThread.join();
        System.out.println(count);
	}

}
