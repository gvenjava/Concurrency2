package com.ch6.collections.blocking.lists.priority;

import java.util.Comparator;

public class Event implements Comparable<Event> {

	private final int thread;
	private final int priority;

	public Event(int thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}

	public int getThread() {
		return thread;
	}

	public int getPriority() {
		return priority;
	}

	/**
	 * Compare the priority of this event and the one given as parameter. It
	 * returns -1 if the priority of this event is bigger, 0 if both priorities
	 * are equal, and 1 if the priority of this event is smaller.
	 * <p>
	 * <b>Note that this is opposite of most
	 * {@link Comparator#compare(Object, Object)} implementations.
	 * 
	 * @param e
	 *            the event to be compared
	 */
	@Override
	public int compareTo(Event e) {
		if (this.priority > e.getPriority()) {
			return -1;
		} else if (this.priority < e.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return new StringBuilder("[thread: ").append(thread)
				.append(", priority: ").append(priority).append("]").toString();
	}

}
