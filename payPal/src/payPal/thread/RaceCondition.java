package payPal.thread;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {
		LongWrapper lw = new LongWrapper(0);
		
		
		Runnable r =()->{
			for(int i=0;i<1000;i++) {
				lw.incrementValue();
			}
		};
		
		Thread[] arr = new Thread[1000];
		for(int i=0;i<1000;i++) {
			arr[i] = new Thread(r);
			arr[i].start();
		}
		for(int i=0;i<1000;i++) {
			arr[i].join();
		}
		
		System.out.println(lw.getValue());

	}

}
