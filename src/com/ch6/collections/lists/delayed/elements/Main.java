/*package com.ch6.collections.lists.delayed.elements;

import static commons.Threads.startAll;
import static commons.Threads.waitForFinalizationOf;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {

	private static final int NUMBER_OF_EVENT_PRODUCERS = 5;

	public static void main(String[] args) {
		DelayQueue<Event> queue = new DelayQueue<>();

		Thread[] eventProducers = createEventProducerThreads(queue);

		startAll(eventProducers);
		waitForFinalizationOf(eventProducers);

		do {
			int counter = 0;
			Event event;
			do {
				event = queue.poll();
				if (event != null) {
					counter++;
				}
			} while (event != null);
			System.out.printf("At %s you have read %d events%n", new Date(),
					counter);
			try {
				TimeUnit.MICROSECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (queue.size() > 0);
	}

	private static Thread[] createEventProducerThreads(DelayQueue<Event> queue) {
		Thread[] threads = new Thread[NUMBER_OF_EVENT_PRODUCERS];
		for (int i = 0; i < threads.length; i++) {
			EventProducer producer = new EventProducer(i, queue);
			threads[i] = new Thread(producer);
		}
		return threads;
	}

}
*/