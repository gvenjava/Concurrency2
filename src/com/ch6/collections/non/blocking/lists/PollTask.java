package com.ch6.collections.non.blocking.lists;

import java.util.Deque;

public class PollTask implements Runnable {

	private Deque<String> list;

	public PollTask(Deque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5000; i++) {
			list.pollFirst();
			list.pollLast();
		}
	}

}