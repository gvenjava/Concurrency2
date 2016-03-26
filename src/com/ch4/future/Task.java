package com.ch4.future;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	private Result result;
	
	public Task(Result result){
		this.result = result;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		result.setTime(String.format("CREATED At : %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp ",Calendar.getInstance()));
	}

}
