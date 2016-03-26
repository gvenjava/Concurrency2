package com.ch4.schedule;

import java.util.Calendar;
import java.util.concurrent.Callable;

public class Task implements Callable<Task> {

	private String name;
	private String dtTime;

	public Task(String name) {
		this.name = name;
	}

	public String getDtTime() {
		return dtTime;
	}

	public void setDtTime(String dtTime) {
		this.dtTime = dtTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public Task call() throws Exception {
		// TODO Auto-generated method stub		
		this.dtTime = String.format("%tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp",Calendar.getInstance());	
		System.out.println(this);
		try {			
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", dtTime=" + dtTime + "]";
	}
	
	

}
