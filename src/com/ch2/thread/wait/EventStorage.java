package com.ch2.thread.wait;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {

	private final int MAX_SIZE;
	private LinkedList<Date> buffer;
	public EventStorage(int maxSize) {
		// TODO Auto-generated constructor stub
		MAX_SIZE = maxSize;
		buffer = new LinkedList<Date>();
		
	}
		
	
	public synchronized void put(){		
		while (buffer.size() == MAX_SIZE){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} 
		Date dt = new Date();
		try{
			buffer.offer(dt);	
		}finally{
			System.out.println("FINALLY IN PUT");
		}
		
		System.out.printf("PRODUCER ID %d, DATE & TIME : %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp%n",Thread.currentThread().getId(),dt);;
		notifyAll();		
	}
	
	public synchronized String get(){		
		while(buffer.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		notifyAll();
		return String.format("CONSUMER ID %d, DATE & TIME : %tm/%<td/%<tY %<tI:%<tM:%<tS %<Tp",Thread.currentThread().getId(),buffer.poll());		
	}
}