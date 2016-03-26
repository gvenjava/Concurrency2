package com.ch3.countdownlatch.example;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		final Worker latch = new Worker(new CountDownLatch(1));
		new Thread(new Runnable(){
			@Override
			public void run(){
				latch.start();
				System.out.println("LATCH ENDED...");
			}
		}).start();

		Thread[] t = new Thread[10];

		for (int i = 1; i <= 10; i++) {
			
			t[i-1] = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						int j = new Random().nextInt(3) + 1;
						//System.out.printf("Name : %s Going To Sleep For %d%n",Thread.currentThread().getName(),j);
						TimeUnit.SECONDS.sleep(j);
						latch.execute(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, "Thread - " + i);
		}
		
		System.out.println("Starting...");
		for(int i=0;i<t.length;i++)
			t[i].start();

	}
}
