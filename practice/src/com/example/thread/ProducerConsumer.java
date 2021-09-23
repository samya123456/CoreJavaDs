package com.example.thread;

public class ProducerConsumer {

	private static int[] buffer;
	private static int count;
	private static Object key = new Object();

	static class Producer {

		public void produce() throws InterruptedException {
			synchronized (key) {
				while (isfull(count)) {
					key.wait();
				}
				buffer[count++] = 1;
				key.notify();
			}
		}

		public boolean isfull(int count) {
			return count == buffer.length;
		}

	}

	static class Consumer {

		public void consume() throws InterruptedException {
			synchronized (key) {
				while (isEmpty(count)) {
					key.wait();
				}
				buffer[--count] = 0;
				key.notify();
			}
		}

		public boolean isEmpty(int count) {
			return count == 0;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		buffer = new int[50];
		count=0;
		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable prodRun = () -> {
			for (int i = 0; i < 5_0; i++) {
				try {
					producer.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable conRun = () -> {
			for (int i = 0; i < 29; i++) {
				try {
					consumer.consume();
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
