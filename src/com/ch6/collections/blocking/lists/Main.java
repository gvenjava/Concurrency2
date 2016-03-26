package com.ch6.collections.blocking.lists;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	private static final int CAPACITY = 3;

	public static void main(String[] args) {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(CAPACITY);
		Thread clientThread = new Thread(new Client(list), "client");
		Thread serverThread = new Thread(new Server(list), "server");
		clientThread.start();
		serverThread.start();

		waitForThreadsFinalization(clientThread, serverThread);

		System.out.printf("[%s][%s] - End of the program%n", Thread
				.currentThread().getName(), new Date());
	}

	private static void waitForThreadsFinalization(Thread clientThread,
			Thread serverThread) {
		try {
			clientThread.join();
			serverThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
