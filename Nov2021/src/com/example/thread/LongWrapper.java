package com.example.thread;

public class LongWrapper {
	
	private int l=0;
	
	public int getLong() {
		return l;
	}
	
	public void incrementValue() {
		synchronized(this) {
			l=l+1;
		}
		
	}

}
