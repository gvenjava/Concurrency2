package com.ch4.runnable;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String threadName;
	private Calendar cal;
	
	public Task(String name){
		this.threadName = name;
		cal = Calendar.getInstance();
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s CREATED At : %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n Priority : %d%n",this.threadName,this.cal,Thread.currentThread().getPriority());
		
		long timeout = (new Random().nextInt(10)+1) * 5;
		System.out.printf("%s Started At : %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n Sleep Time : %d%n",this.threadName,Calendar.getInstance(),timeout);
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"---"+Thread.currentThread().getName());
			//e.printStackTrace();
		}
		System.out.printf("%s Completed At : %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n Slept for : %d%n",this.threadName,Calendar.getInstance(),timeout);
	}



	@Override
	public String toString() {
		return "Task [threadName=" + threadName + "]";
	}
	
	
	
}
