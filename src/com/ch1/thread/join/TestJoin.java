package com.ch1.thread.join;

import java.util.Calendar;

public class TestJoin {

	public static void main(String[] args) {
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader,"DataSourceLoader");
		
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
//			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: loading finished: %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n",Calendar.getInstance());
	}

}
