package com.ch5.task;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Run implements Runnable {

	private Result result;
	
	public Run(Result r){
		this.result = r;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		result.setBefore(String.format("%tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n ",Calendar.getInstance()));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.setTimeStamp(String.format("%tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n ",Calendar.getInstance()));
	}

}
