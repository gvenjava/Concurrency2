package com.ch4.service;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Producer implements Callable<String> {

	private String name;
	private String title;
	private Random rnd = new Random();

	public Producer(String n, String t) {
		this.name = n;
		this.title = t;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		TimeUnit.SECONDS.sleep(rnd.nextLong() + 1);
		return this.name + " : " + this.title;
	}

}
