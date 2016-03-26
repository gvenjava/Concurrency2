package com.ch3.semaphores.tryacquire;

import java.util.Calendar;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ExThread implements Runnable {

	private long time;
	private Semaphore s;
	private boolean flag;

	public ExThread(long t, Semaphore s) {
		this.time = t;
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().isInterrupted());
		try {
//			flag = s.tryAcquire(1, 3, TimeUnit.SECONDS);
			flag = s.tryAcquire(1,1,TimeUnit.DAYS);
//			s.acquire();
			// System.out.printf("Data sources loading finished: %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n",Calendar.getInstance());
			System.out
					.printf("Thread Name : %s, %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp ,Going to Sleep for : %d, %n",
							Thread.currentThread().getName(),
							Calendar.getInstance(), this.time);
			TimeUnit.SECONDS.sleep(this.time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			System.out.printf("Name : %s, Exception : %s, isInterrupted? %b%n",
					Thread.currentThread().getName(), e.getMessage(), Thread
							.currentThread().isInterrupted());
		} finally {
			if (flag)
				s.release();

			System.out
					.printf("Thread Name : %s, %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp ,Lock Released %b, isInterrupted? %b%n",
							Thread.currentThread().getName(), Calendar
									.getInstance(), this.flag, Thread
									.currentThread().isInterrupted());
		}

	}

}
