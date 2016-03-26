package com.ch3.cyclicbarrier;

public class Grouper implements Runnable {

	private Results results;
	
	public Grouper(Results results) {
		this.results = results;
	}

	@Override
	public void run() {
		System.out.println("Grouper starts processing..");
		
		int finalCount=0;
		for (int rowCount : results.getCount()) {
			finalCount+=rowCount;
		}
		
		System.out.printf("Grand total is %d.%n",finalCount);
	}

}
