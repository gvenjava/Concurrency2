package com.ch1.thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {
	
	private Deque<Event> deque;
	public WriterTask(Deque<Event> d) {
		deque = d;
	}

	@Override
	public void run() {
		
		for (int i=1; i<100; i++) {
			Event event=new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated an event",Thread.currentThread().getId()));
			deque.addFirst(event);
			System.out.println("Adding:"+event.getEvent());// Interesting : if comment this line, Size vary.
			
			try {				
				TimeUnit.SECONDS.sleep(1);				
			} catch (InterruptedException e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println(String.format("The thread %s has been interrupted ",Thread.currentThread().getId()));
				System.exit(0);
			}
		}
	}

}
