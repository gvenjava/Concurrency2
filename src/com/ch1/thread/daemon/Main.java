package com.ch1.thread.daemon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Deque<Event> deque = new ArrayDeque<Event>();
		WriterTask task = new WriterTask(deque);
		Thread[] tArray = new Thread[3];
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(task);
			thread.start();
			tArray[i] = thread;
		}
		CleanerTask cleanerTask = new CleanerTask(deque);
		cleanerTask.start();
		System.out.printf("CLEANER TASK THREAD STATE %s%n",cleanerTask.getState());
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
			cleanerTask.interrupt();
			
			for(Thread t : tArray){
				//t.interrupt();
			}
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Is the cleaner task a daemon :"+cleanerTask.isDaemon());
		System.out.printf("CLEANER TASK THREAD STATE %s%n",cleanerTask.getState());
	}

}
