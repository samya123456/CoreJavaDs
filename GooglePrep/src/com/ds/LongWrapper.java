package com.ds;

public class LongWrapper {
	
	public long value =0;
	
	public void incrementValue() {
		synchronized(this) {
			this.value = this.value +1;
		}
		
	}
	
	public long getLong() {
		return this.value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
