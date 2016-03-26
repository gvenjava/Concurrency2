package com.ch1.thread.daemon;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {

	private Deque<Event> deque;
	public CleanerTask(Deque<Event> d) {
		deque = d;
		setDaemon(true);
	}
	
	@Override
	public void run() {
		boolean flag = true;
		while(flag) {
			Date date = new Date();			
			if(isInterrupted()){				
				System.out.println(String.format("The CLEANER thread %s has been interrupted ",Thread.currentThread().getId()));
				flag = false;
			}else{
				clean(date);
			}
		}
	}
	
	private void clean(Date date) {
		long difference;
		boolean delete;
		if (deque.size()==0) {
			return;
		}
		delete=false;
		do {
			/*System.out.printf("Cleaner: Size of the queue: %d\n",deque.
					size());*/
			Event e = deque.getLast();
			difference = date.getTime() - e.getDate().getTime();
			if (difference > 5000) {
				System.out.printf("Cleaner: %s\n",e.getEvent());
				deque.removeLast();
				delete=true;
			}
		} while (difference > 5000);
		if (delete){
			System.out.printf("Cleaner: Size of the queue: %d\n",deque.
					size());
		}
	}
}
