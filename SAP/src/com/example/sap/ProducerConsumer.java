package com.example.sap;

public class ProducerConsumer {

	static  int[] buffer;
	static  int count;
	private static final  Object key = new Object();

	static class Producer {
		public   void produce() throws InterruptedException {
			
			synchronized(key) {
			if (isFull(buffer)) {
				key.wait();
			}
			buffer[count++] = 1;
			key.notifyAll();
			}
			
			
		}

		private  boolean isFull(int[] buffer) {
			
			return count == buffer.length;
		}

	}
	
	static class Consumer {
		public  void consume() throws InterruptedException {
			
			synchronized(key) {
			if(isEmpty(buffer)) {
				key.wait();
			}
			
			buffer[--count] =0;
			
			key.notifyAll();
			}
		}
		private  boolean isEmpty(int[] buffer) {
			
			return count==0;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		buffer =new int[10];
		count=0;
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Runnable producerTask = ()->{
			for(int i=0;i<50;i++) {
				try {
					producer.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumerTask = ()->{
			for (int i=0;i<45;i++) {
				try {
					consumer.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t1 = new Thread(producerTask);
		Thread t2 = new Thread(consumerTask);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(count);
	}

}
