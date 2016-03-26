package com.ch6.collections.non.blocking.lists;

import java.util.Deque;

public class AddTask implements Runnable {

	private Deque<String> list;

	public AddTask(Deque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 10000; i++) {
			list.add(name + ": Element " + i);
		}

	}

}