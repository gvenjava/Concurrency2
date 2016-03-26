package com.ch4.schedule;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * FixedRate : Job should run for every 2 secs
 1st Job : 10:02 AM
 2nd Job : 10:04 AM (Execution time 4 secs)
 3rd Job : 10:08 AM 

 FixedDelay : Job should run after the first one completes (2 Secs)
 1st Job : 10:00 AM
 2nd Job : 10:02 AM (Execution time 4 secs)
 3rd Job : 10:08 AM



 */

public class Main {
	ScheduledExecutorService fdService = Executors.newScheduledThreadPool(10);
	void fixedDelay() {		
		fdService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.printf("%s %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",Thread.currentThread().getName(),
						Calendar.getInstance());
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.printf("%5s %5tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",Thread.currentThread().getName(),
						Calendar.getInstance());
			}

		}, 1, 2, TimeUnit.SECONDS);
	}
	
	ScheduledExecutorService frService = Executors.newScheduledThreadPool(2);
	void fixedRate() {
		frService.scheduleAtFixedRate(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.printf("%s %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",Thread.currentThread().getName(),
						Calendar.getInstance());
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.printf("%5s %5tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",Thread.currentThread().getName(),
						Calendar.getInstance());
			}

		}, 0, 2, TimeUnit.SECONDS);
		

	}

	void execute() {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(1);

		for (int i = 1; i <= 5; i++) {
			executor.schedule(new Task("Thread " + i), i * 1, TimeUnit.SECONDS);
		}

		executor.shutdown();
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Main m = new Main();
		//m.fixedDelay();
		
		System.out.printf("MAIN START ::: %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",
				Calendar.getInstance());
		try {
			//m.fixedRate();
			m.fixedDelay();
			TimeUnit.SECONDS.sleep(60);
			//m.frService.shutdown();
			m.fdService.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("MAIN END ::: %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",
				Calendar.getInstance());
	}
}
