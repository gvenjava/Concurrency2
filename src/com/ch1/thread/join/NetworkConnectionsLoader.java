package com.ch1.thread.join;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable{

	@Override
	public void run() {
		System.out.printf("Beginning network connections loading: %1tm/%<td/%<tY%n", Calendar.getInstance());
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Network connections loading finished: %1tm/%<td/%<tY%n", new Date());
	}
}
