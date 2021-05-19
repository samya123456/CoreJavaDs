package com.example.sap;

public class LongWrapper {
	
	private  Long l;
	
	private final Object key = new Object();
	
	public LongWrapper(Long l) {
		this.l=l;
	}
	
	public Long getValue() {
		return this.l;
	}
	
	public void incrementLong() {
		synchronized(key) {
			l=l+1;
		}
		
	}

}
