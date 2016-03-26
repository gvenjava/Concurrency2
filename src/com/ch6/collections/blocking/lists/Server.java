package com.ch6.collections.blocking.lists;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * The {@link Server} uses the {@link LinkedBlockingDeque#take()} method to get
 * strings from the list. If the list is empty, the method blocks the execution
 * of its thread until there are elements in the list.
 */
public class Server implements Runnable {

	private final LinkedBlockingDeque<String> list;

	public Server(LinkedBlockingDeque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				try {
					String request = list.take();
					System.out
							.printf("[%s][%s] - Request taken %s; size of the list %s%n",
									Thread.currentThread().getName(),
									new Date(), request, list.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			sleepToLetClientPutRequests();
		}
	}

	private void sleepToLetClientPutRequests() {
		try {
			TimeUnit.MICROSECONDS.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
