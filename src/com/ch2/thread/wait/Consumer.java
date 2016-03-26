package com.ch2.thread.wait;

public class Consumer implements Runnable {

	private EventStorage storage;
	private final int MAX_SIZE;
	public Consumer(EventStorage st,int MAX_SIZE) {
		// TODO Auto-generated constructor stub
		this.storage = st;
		this.MAX_SIZE = MAX_SIZE;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub	
		
		for(int i =0;i<MAX_SIZE;i++)
			System.out.println(storage.get());		
	}
}