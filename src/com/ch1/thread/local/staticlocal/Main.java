package com.ch1.thread.local.staticlocal;

import java.util.concurrent.TimeUnit;

public class Main {

	private static ThreadLocal<String> threadName = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadName.set(Thread.currentThread().getName());
				System.out.println("Set 1:"+Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Get 1:"+threadName.get());
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadName.set(Thread.currentThread().getName());
				System.out.println("Set 2:"+Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Get 2:"+threadName.get());
			}
		});
		
		t1.start();
		t2.start();

	}

}
