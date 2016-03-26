package com.ch1.thread.sleep;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


/**
 * @author Venkatesh
 * 
 * Sample for sleep method.
 *
 */
public class FileClock implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%1$tm/%<td/%<tY%n", Calendar.getInstance());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.out.printf("FileClock has been interrupted!");				
			}
		}
	}
}
