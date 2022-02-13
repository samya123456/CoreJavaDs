
public class DeadLock {
	private final Object key1 = new Object();
	private final Object key2 = new Object();
	
	public void a() {
		synchronized(key1) {
			System.out.println("inside a");
			b();
		}
	}
	public void b() {
		synchronized(key2) {
			System.out.println("inside b");
			c();
		}
	}

	private void c() {
		synchronized(key1) {
			System.out.println("inside c");
			
		}
		
	}
	public static void main(String[] args) {
		DeadLock deadLock = new DeadLock();
		Runnable r1 =()->{
			deadLock.a();
		};
		Runnable r2 =()->{
			deadLock.b();
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

	}

}
