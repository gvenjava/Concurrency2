package com.ch6.delay;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private int id;
	private DelayQueue<Event> queue;

	public Task(DelayQueue<Event> queue, int id) {
		this.queue = queue;
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis() + (this.id * 1000));
			queue.add(new Event(cal));
		}

	}

	public static void main(String[] args) {

		DelayQueue<Event> queue = new DelayQueue<>();
		Thread[] t1 = new Thread[5];

		for (int i = 0; i < t1.length; i++) {
			t1[i] = new Thread(new Task(queue, i + 1));
			t1[i].start();
		}
		
		for(int i =0;i<t1.length;i++){
			try {
				t1[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		int count = queue.size();
		
		do{
			
			Event e = queue.poll();
			
			while(e == null){
				try {
					TimeUnit.SECONDS.sleep(3);
					e = queue.poll();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			int currentCount = count - queue.size();
			
			System.out.printf("Current Queue Size %d, %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n ",currentCount,Calendar.getInstance());
			
		}while(queue.size()>0);
	}

}
