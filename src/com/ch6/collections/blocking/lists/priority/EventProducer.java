package com.ch6.collections.blocking.lists.priority;

import java.util.concurrent.PriorityBlockingQueue;

public class EventProducer implements Runnable {

	private final int id;
	private final PriorityBlockingQueue<Event> queue;

	public EventProducer(int id, PriorityBlockingQueue<Event> queue) {
		this.id = id;
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			Event event = new Event(id, i);
			queue.add(event);
		}
	}

}
