package com.example.thread;

public class ProdConThread {

	private static final Object lock = new Object();
	static int count = 0;
	static int[] buffer= new int[10];

	static class Producer {
		public void produce() throws InterruptedException {

			synchronized (lock) {
				while (isfull(buffer)) {
					lock.wait();
				}
				buffer[count++] = 1;
				lock.notify();

			}
		}

		private boolean isfull(int[] buffer) {

			return count == buffer.length;
		}
	}

	static class Consumer {

		public void consume() throws InterruptedException {

			synchronized (lock) {
				while (isEmpty(count)) {
					lock.wait();
				}
				buffer[--count] = 0;
				lock.notify();

			}
		}

		private boolean isEmpty(int count) {
			// TODO Auto-generated method stub
			return count==0;
		}

		
	}

	public static void main(String[] args) throws InterruptedException {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable prodRun =()->{
			try {
				for(int i=0;i<10;i++) {
					producer.produce();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable conRun =()->{
			try {
				for(int i=0;i<9;i++) {
					consumer.consume();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread prodT = new Thread(prodRun);
		Thread conT = new Thread(conRun);
		
		prodT.start();
		conT.start();
		prodT.join();
		conT.join();
		
		System.out.println(count);

	}

}
