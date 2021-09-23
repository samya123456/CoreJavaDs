package com.example.thread;

public class RaceCondition {
	
	
	public static class LongWrapper{
		
		private static final Object key = new Object();
		
		private Long l;
		
		public LongWrapper(Long l) {
			this.l =l;
		}
		
		public Long getValue() {
			return this.l;
		}
		
		public void incrementValue() {
			synchronized(key) {
				this.l=l+1;
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		LongWrapper longWrapper = new LongWrapper(0l);
		Runnable r =()->{
			for(int i=0;i<1_000;i++) {
				longWrapper.incrementValue();
			}
		};
		
		Thread[] threadpool = new Thread[1_000];
		
		for(int i =0;i<1_000;i++) {
			threadpool[i] = new Thread(r);
			threadpool[i].start();
		}
		
		for(int i =0;i<1_000;i++) {
		
			threadpool[i].join();
		}
		
		System.out.println(longWrapper.getValue());
		

	}

}
