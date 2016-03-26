package com.ch4.service;

import java.util.concurrent.CompletionService;

public class Consumer implements Runnable {

	private String name;
	private CompletionService<String> service;

	public Consumer(String name, CompletionService<String> s) {
		this.name = name;
		this.service = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.submit(new Producer(name, "REPORT"));
	}

}
