package com.example.dp;

public class SingleTonClass {
	
	private static SingleTonClass instance;
	
	private SingleTonClass() {
		
	}
	
	public static SingleTonClass getInstance() {
		if(instance==null) {
			instance = new SingleTonClass();
		}
		return instance;
	}

	public static void main(String[] args) {


	}

}
