package com.ch3.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {

	private final CountDownLatch controller;
	
	public Videoconference(int number) {
		controller=new CountDownLatch(number);
	}
	
	@Override
	public void run() {
		System.out.printf("Video Conferrance expecting %d participants.%n",controller.getCount());
		
		try {
			controller.await();
			System.out.println("All participants came.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void arrived(String name) {
		System.out.printf("%s has arrived.%n",name);
		controller.countDown();
		getCount();
	}
	
	public void getCount() {
		System.out.printf("Waiting for %d persons.%n",controller.getCount());
	}
}
