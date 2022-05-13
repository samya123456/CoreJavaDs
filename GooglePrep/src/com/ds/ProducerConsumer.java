package com.ds;

public class ProducerConsumer {
	
	
	private static final Object lock = new Object();
	private static int[] buffer;
	private static int count;
	
	static class Producer {
		
		public void produce() {
			synchronized(lock) {
			 while(isFull(buffer)) {
				try {
					lock.wait();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
			 buffer[count++]=1;
				lock.notify();
			
			}
		}

		
		private boolean isFull(int[] buffer) {
			
			return count==buffer.length;
		}
	}
	
	static class Consumer{
		
		public void consume() {
			synchronized(lock) {
				while(isEmpty(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				buffer[--count] =0;
				lock.notify();
			}
		}

		
	  private boolean isEmpty(int[] buffer) {
			
			return count==0;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		count=0;
		buffer =new int[10];
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable prod = ()->{
				for(int i=0;i<10;i++) {
					producer.produce();
				}
		};
		
		Runnable con = ()->{
			for(int i=0;i<1;i++) {
				consumer.consume();
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
