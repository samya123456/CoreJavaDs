
public class LongWrapper {

	private long l;
	
	LongWrapper(long l){
		this.l =l;
	}
	
	public long getLong() {
		return l;
	}
	
	public void incrementValue() {
		synchronized(this) {
			l++;
		}
		
	}
	
	

}
