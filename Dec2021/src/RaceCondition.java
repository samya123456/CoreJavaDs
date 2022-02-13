
public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {
		LongWrapper longWrapper = new LongWrapper(0l);

		Runnable r = () -> {
			for (int i = 0; i < 1000; i++) {
				longWrapper.incrementValue();
			}

		};
		
		Thread[] threadArr = new Thread[1000];
		for(int i=0;i<threadArr.length;i++) {
			threadArr[i] = new Thread(r);
			threadArr[i].start();
		}
		
		for(int i=0;i<1000;i++) {
			threadArr[i].join();
		}
		
		System.out.println(longWrapper.getLong());

	}

}
