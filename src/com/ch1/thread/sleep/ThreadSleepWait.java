package com.ch1.thread.sleep;

import java.util.concurrent.TimeUnit;

public class ThreadSleepWait {

	void execute(){
		
		final Object obj = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (obj) {
					System.out.println("Acquired Object Lock");
					try {
						//TimeUnit.MINUTES.sleep(1);
						obj.wait(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					obj.notify();
					System.out.println("Woken Up!!!");					
				}
			}
			
		});
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Waiting for Lock...");
				synchronized (obj) {
						System.out.println("Acquired Lock From OBJECT");
				}
			}
			
		});
		
		t2.start();
	}
	public static void main(String[] args){
		ThreadSleepWait obj = new ThreadSleepWait();
		obj.execute();
		
	}
}