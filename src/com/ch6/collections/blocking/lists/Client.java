package com.ch6.collections.blocking.lists;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * The {@link Client} uses the {@link LinkedBlockingDeque#put(Object)} method to
 * insert strings in the list. If the list is full, the method blocks the
 * execution of its thread until there is an empty space in the list.
 */
public class Client implements Runnable {

	private final LinkedBlockingDeque<String> list;

	public Client(LinkedBlockingDeque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				StringBuilder request = new StringBuilder();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					list.put(request.toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("[%s][%s] - Created request %s%n", Thread
						.currentThread().getName(), new Date(), request);
			}
			sleepToLetServerTakeRequests();
		}
		System.out.printf("[%s][%s] - Finished%n", Thread.currentThread()
				.getName(), new Date());
	}

	private void sleepToLetServerTakeRequests() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
