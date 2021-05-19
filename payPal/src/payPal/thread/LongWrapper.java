package payPal.thread;

public class LongWrapper {
	
	int l;
	private final Object key = new Object();
	LongWrapper(int l){
		this.l =l;
	}
	
	
	public int getValue() {
		return l;
	}
	public void incrementValue() {
		synchronized(key) {
			l=l+1;
		}
		
	}

	public static void main(String[] args) {
		

	}

}
