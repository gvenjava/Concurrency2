package com.ch4.ecs;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Result implements Callable<Result> {

	private String tStamp;

	private Random rnd = new Random();

	public Result(int i) {
		tStamp = String.format(
				"OBJECT %d, %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n", i,
				Calendar.getInstance());
	}

	public String gettStamp() {
		return tStamp;
	}

	public void settStamp(String tStamp) {
		this.tStamp = tStamp;
	}

	@Override
	public Result call() throws Exception {
		// TODO Auto-generated method stub

		int sleep = rnd.nextInt(10) + 1;
		System.out.println("SLEEP TIME = "+sleep);
		TimeUnit.SECONDS.sleep(sleep);
		System.out.println("Woke Up "+this);
		return this;
	}

	@Override
	public String toString() {
		return "Result tStamp = " + tStamp;
	}

}
