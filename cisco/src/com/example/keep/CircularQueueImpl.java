package com.example.keep;

import java.util.ArrayList;
import java.util.Queue;

public class CircularQueueImpl {
	
	private int size , front ,rare;
	private ArrayList<Integer> queue = new ArrayList<Integer>();
	
	CircularQueueImpl(int size){
		this.size =size;
		front = rare = -1;
	}
	
	public void enQueue(int data) {
		
		if((front==0 && rare==size-1) || rare ==(front-1)%(size-1)) {
			System.out.println("Queue is full");
		} else if(front==-1) {
			front =0;rare =0;
			queue.add(rare, data);
		} else if(rare==(size-1) && front != 0) {
			rare =0;
			queue.add(rare, data);
		} else {
			queue.add(++rare, data);
		}
		
	}

	public static void main(String[] args) {
	

	}

}
