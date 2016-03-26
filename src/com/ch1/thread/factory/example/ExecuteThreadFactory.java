package com.ch1.thread.factory.example;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecuteThreadFactory {

	public static void main(String[] args) {

		Runnable r = new Runnable() {

			@Override
			public void run() {
				//notify();
				


				// TODO Auto-generated method stub
				try {					
					System.out.println(Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};

		ThreadFactory factory = new ThreadFactory() {
			private int count = 0;

			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				count++;
				Thread t = new Thread(r, "THREAD - " + count);
				System.out.println("COUNT = " + count);
				return t;
			}

		};

		for (int i = 1; i < 11; i++) {
			Thread t = factory.newThread(r);
			t.start();

		}
		
		

	}
}
