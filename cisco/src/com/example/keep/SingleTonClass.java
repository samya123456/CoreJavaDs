package com.example.keep;

public class SingleTonClass {
	
	
	private static  SingleTonClass instance;
	private final static Object key = new Object();
	
	private SingleTonClass() {
		
	}
	
	public static SingleTonClass getInstance() {
		
		synchronized(key) {
			if(instance==null) {
				instance = new SingleTonClass();
			}
			return instance;
		}
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
