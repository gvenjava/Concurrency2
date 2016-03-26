package com.ch1.thread.join;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable{

	@Override
	public void run() {
		System.out.printf("Beginning data sources loading: %1tm/%<td/%<tY%n", Calendar.getInstance());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Data sources loading finished: %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n",Calendar.getInstance());
	}
}
