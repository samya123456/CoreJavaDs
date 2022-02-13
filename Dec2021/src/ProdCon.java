
public class ProdCon {
	
	private static int buffer[];
	private static int count;
	private static final Object key =new Object();
	
	
	 static class Producer {
		public void produce() throws InterruptedException {
			synchronized(key) {
				while(isFull(buffer)) {
					key.wait();
				}
				buffer[count++] =1;
				key.notify();
			}
		}

		private boolean isFull(int[] buffer) {
			// TODO Auto-generated method stub
			return buffer.length==count;
		}
	}
	 
	 static class Consumer {
			public void consume() throws InterruptedException {
				synchronized(key) {
					while(isEmpty(buffer)) {
						key.wait();
					}
					buffer[--count] =0;
					key.notify();
				}
			}

			private boolean isEmpty(int[] buffer) {
				
				return count==0;
			}
		}

	public static void main(String[] args) throws InterruptedException {
		buffer =new int[50];
		count=0;
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Runnable prod =()->{
			for(int i=0;i<10;i++) {
				try {
					producer.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable con =()->{
			for(int i=0;i<9;i++) {
				try {
					consumer.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread prodThread = new Thread(prod);
		Thread conThread = new Thread(con);
		prodThread.start();
		conThread.start();
		prodThread.join();
		conThread.join();
		System.out.println(count);

	}

}
