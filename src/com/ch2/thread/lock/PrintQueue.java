package com.ch2.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Lock queueLock=new ReentrantLock();
	
	public void printJob(){//Object document
//		queueLock.lock();
		try {
			if(queueLock.tryLock(20,TimeUnit.SECONDS)) {
			
				Long duration=(long)(Math.random()*10000);
				System.out.println(Thread.currentThread().getName()+ ": PrintQueue: Printing a Job during "+(duration/1000)+
						" seconds");
				Thread.sleep(duration);			
			} else {
				System.out.println(Thread.currentThread().getName()+ ": Already a thread has lock");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			queueLock.unlock();
		}
	}
}