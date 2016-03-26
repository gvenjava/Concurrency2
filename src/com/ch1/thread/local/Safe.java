package com.ch1.thread.local;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Safe implements Runnable {

	String finish = "NOT FINISHED";
	
	String parent = "";
	
	public Safe(){
		
	}
	
	public Safe(String finish,String id){
		this.finish = finish;
		this.parent = id;
	}
	
	
	
	ThreadLocal<Date> cal = new InheritableThreadLocal<Date>(){
		
		@Override
		protected Date initialValue(){
			return new Date();
		}
		
		@Override
		protected Date childValue(Date d){
			return new Date();
		}
	};
	
	@Override
	public void run() {
		// TODO Auto-generated method stub		
		long time = (long) Math.ceil(Math.random() * 10);
		final String tmp = new Long(Thread.currentThread().getId()).toString();
		System.out.printf("THREAD NAME : %s ,PARENT Id: %s, CREATED AT : %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n", tmp,this.parent, cal.get());
		
		try {
			
			TimeUnit.SECONDS.sleep(time);
			
			if(!this.finish.equalsIgnoreCase("FINISH")){
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						System.out.printf("Child of %s has  %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n",tmp,cal.get());
					}
				}).start();//new Safe("FINISH",tmp)
			}
						
			//cal.set(new Date());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("THREAD NAME : %s , SLEEP TIME : %d PARENT Id : %s COMPLETED AT : %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n",Thread.currentThread().getId(),time,this.parent,cal.get());
		
		
	}

	
}
