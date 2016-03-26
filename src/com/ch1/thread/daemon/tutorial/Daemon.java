package com.ch1.thread.daemon.tutorial;

import java.util.concurrent.TimeUnit;

public class Daemon {

	public static void main(String[] args) {

		T1 tmp = new T1(25);

		Thread t = new Thread(tmp, "DAEMON THREAD");
		t.setDaemon(true);
		t.start();

		Thread t2 = new Thread(tmp, "NON DAEMON THREAD");
		tmp.setTime(5);
		t2.start();
		

	}
}

class T1 implements Runnable {

	private int time;
	
	T1(int t){
		this.time = t;
	}
	
	
	
	public void setTime(int time) {
		this.time = time;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(this.time);
			System.out.println("WOKE UP " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
