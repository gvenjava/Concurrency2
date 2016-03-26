package com.ch3.countdownlatch.example;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

public class Worker {

	private CountDownLatch latch;

	public Worker(CountDownLatch latch) {

		this.latch = latch;
	}

	public void execute(String name) {

		//if (latch.getCount() > 0) {
			latch.countDown();
			/*latch.countDown();
			latch.countDown();
			latch.countDown();
			latch.countDown();
			latch.countDown();*/
			System.out
					.printf("Latch Initiated by %s at : %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp, Current Count : %d%n",
							name, Calendar.getInstance(), latch.getCount());
		//}

	}

	public void start() {

		try {
			System.out
					.printf("Latch Count : %d, Started at %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",
							latch.getCount(), Calendar.getInstance());
			latch.await();
			System.out
					.printf("Latch Count : %d,Ended at %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",
							latch.getCount(), Calendar.getInstance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
