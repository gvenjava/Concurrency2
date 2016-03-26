package com.ch1.thread.local;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Unsafe implements Runnable {

	private Date cal;
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		cal = new Date();
		//%1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n
		System.out.printf("THREAD NAME : %s , CREATED AT : %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n",Thread.currentThread().getId(),cal);
		
		try {
			TimeUnit.SECONDS.sleep((long) (Math.ceil(Math.random() * 10)));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("THREAD NAME : %s , COMPLETED AT : %1tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp %n",Thread.currentThread().getId(),cal);
		
		
	}

}
