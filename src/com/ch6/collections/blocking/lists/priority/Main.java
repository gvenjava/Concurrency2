/*package com.ch6.collections.blocking.lists.priority;

import static commons.Threads.startAll;
import static commons.Threads.waitForFinalizationOf;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	*//** The number of threads producing events. *//*
	private static final int NUMBER_OF_EVENT_PRODUCERS = 5;

	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
		
		Thread[] eventProducers = createEventProducerThreads(queue);

		startAll(eventProducers);
		waitForFinalizationOf(eventProducers);

		printQueueSize(queue);

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

		printQueueSize(queue);
	}

	private static Thread[] createEventProducerThreads(
			PriorityBlockingQueue<Event> queue) {
		Thread[] taskThreads = new Thread[NUMBER_OF_EVENT_PRODUCERS];
		for (int i = 0; i < taskThreads.length; i++) {
			EventProducer task = new EventProducer(i, queue);
			taskThreads[i] = new Thread(task);
		}
		return taskThreads;
	}

	private static void printQueueSize(PriorityBlockingQueue<Event> queue) {
		System.out.printf("[%s] - Queue size: %d%n", Thread.currentThread()
				.getName(), queue.size());
	}

}
*/