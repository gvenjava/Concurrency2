package com.ch6.collections.non.blocking.lists;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

	public static void main(String[] args) {
		Deque<String> list = new ConcurrentLinkedDeque<>();
		// Deque<String> list = new LinkedList<>();

		Thread[] addingThreads = launchThreadsAddingToTheList(list);
		System.out.printf("Main: %d AddTask threads have been launched%n",
				addingThreads.length);
		waitForFinalizationOfThreads(addingThreads);

		printListSize(list);

		Thread[] removingThreads = launchThreadsRemovingFromTheList(list);
		System.out.printf("Main: %d PollTask threads have been launched%n",
				removingThreads.length);
		waitForFinalizationOfThreads(removingThreads);

		printListSize(list);
	}

	private static Thread[] launchThreadsRemovingFromTheList(Deque<String> list) {
		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			PollTask task = new PollTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		return threads;
	}

	private static Thread[] launchThreadsAddingToTheList(Deque<String> list) {
		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			AddTask task = new AddTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		return threads;
	}

	private static void waitForFinalizationOfThreads(Thread[] threads) {
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printListSize(Deque<String> list) {
		System.out.printf("Main: Size of the list: %d%n", list.size());
	}

}