package com.ch2.thread.wait;

public class Producer implements Runnable {

	private EventStorage storage;
	private final int MAX_SIZE;
	public Producer(EventStorage st,int MAX_SIZE) {
		// TODO Auto-generated constructor stub
		this.storage = st;
		this.MAX_SIZE = MAX_SIZE;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<MAX_SIZE;i++){
			storage.put();
		}		
	}

}
