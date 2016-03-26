package com.ch3.phaser.website;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserOnAvance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Phaser phaser = new Phaser(2) {
			protected boolean onAdvance(int phase, int parties) {
				switch (phase) {
				case 0:
					return result(false, 1);
				case 1:
					return result(false, 2);
				case 2:
					return result(true,3);
				default:
					return true;
				}

			}

			private boolean result(boolean f, int s) {
				System.out.println("Current Phase = " + s);
				return f;
			}
		};

		final List<Runnable> list = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			final int y = 2; // - ((i % 2 == 0) ? 1 : 3);

			Runnable r = new Runnable() {
				@Override
				public void run() {
					System.out.println("Thread Name : "
							+ Thread.currentThread().getName());
					try {
						TimeUnit.SECONDS.sleep(y);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Woken Up!!! "
							+ Thread.currentThread().getName());
				}
			};
			list.add(r);
		}

		for (int i = 0; i < list.size(); i++) {
			final int k = i;
			 phaser.register(); // -- 3, --4;
			System.out.println("UNARRIVED PARTIES === "
					+ phaser.getUnarrivedParties() + " ARRIVED PARTIES === "
					+ phaser.getArrivedParties());
			new Thread(new Runnable() {
				@Override
				public void run() {
					/*	
					 * Though the Phaser object is initialized with 2 and 2 more are registered at run time, the initial parties are 
					 * emptied using dummy arrive method.
					 *  
					 * Initial 2
					 * 
					 * Phase 0 for Thread 1
					 * When you register a party count become  2+1 {3} Parties
					 * At this stage unarrived parties count = 3
					 * When you call arrive,for phase 0, arrived parties count = 1, and unarrived parties count = 2 
					 * When you call arriveAndAwaitAdvance for phase 0, arrived parties count = 2, and unarrived parties count = 1  
					 * In the above scenario it goes into wait mode for remaining 1 party to come in.
					 * 
					 * Phase 0 for Thread 2
					 * When you register another party the count becomes 3+1 {4} Parties
					 * At this stage unarrived parties count = 2
					 * When you call arrive,for phase 0, arrived parties count = 3, and unarrived parties count = 1
					 * When you call arriveAndAwaitAdvance for phase 0, arrived parties count = 4, and unarrived parties count = 0
					 * At this stage onAdvance method is called and switch statement executed for phase '0'
					 * 
					 * Phase 1 for Thread 1
					 * At this stage unarrived parties count = 4
					 * When you call arrive,for phase 1, arrived parties count = 1, and unarrived parties count = 3 
					 * When you call arriveAndAwaitAdvance for phase 1, arrived parties count = 2, and unarrived parties count = 2  
					 * In the above scenario it goes into wait mode for remaining 2 party to come in.
					 * 
					 * Phase 1 for Thread 2
					 * When you call arrive for phase 1, arrived parties count = 3 and unarrived parties count = 1
					 * When you call arriveAndAwaitAdvance for phase 1, arrived parties count = 4, and unarrived parties count = 0
					 * At this stage onAdvance method is called and switch statement executed for phase '1'
					 * 
					 * Phase 2 for Thread 1
					 * When you call arrive for phase 2, arrived parties count = 1 and unarrived parties count = 3
					 * When you call arriveAndAwaitAdvance for phase 2, arrived parties count = 2, and unarrived parties count = 2 
					 * In the above scenario it goes into wait mode for remaining 2 party to come in.
					 * 
					 * Phase 2 for Thread 2
					 * When you call arrive for phase 2, arrived parties count = 3 and unarrived parties count = 1
					 * When you call arriveAndAwaitAdvance for phase 2, arrived parties count = 4, and unarrived parties count = 0
					 * At this stage onAdvance method is called and switch statement executed for phase '2'
					 * 
					 * 
					 */
					
					phaser.arrive();					
					phaser.arriveAndAwaitAdvance();
					
					
					list.get(k).run();
					
					phaser.arrive();					
					phaser.arriveAndAwaitAdvance();
					
					phaser.arrive();
					phaser.arriveAndAwaitAdvance();
				//	phaser.arriveAndAwaitAdvance();
					System.out.println("***********Phaser Count === "
							+ phaser.getUnarrivedParties()
							+ " ARRIVED PARTIES === "
							+ phaser.getArrivedParties());

				}
			}, "Thread " + i).start();

		}
		
		/*int tmp = phaser.arriveAndDeregister();
		System.out.println("###Phaser Count = " + tmp);
		tmp = phaser.arriveAndDeregister();
		System.out.println("###Phaser Count = " + tmp);*/

	}

}
