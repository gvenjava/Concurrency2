package com.ch3.semaphores.multiresource;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	private boolean freePrinters[];
	private Lock lockPrinters;
	private final Semaphore semaphore;
	
	public PrintQueue() {
		semaphore = new Semaphore(4,true);
		freePrinters = new boolean[3];
		for (int i = 0; i < freePrinters.length; i++) {
			freePrinters[i]=true;
		}
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob (Object document){
		try {
			semaphore.acquire(2);
			
			int[] assignedPrinter = getPrinter();
			
			long duration=(long)(Math.random()*10);
			
			System.out.printf("%s%n PrintQueue: Printing a Job in Printer %s during %d seconds\n",Thread.currentThread().getName(),Arrays.toString(assignedPrinter),duration);
			TimeUnit.SECONDS.sleep(duration);
			
			for(int i =0; i<assignedPrinter.length;i++)				
				freePrinters[assignedPrinter[i]]=true;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release(2);
		}
	}

	private int[] getPrinter() {
//		int ret=-1;
		int[] val = new int[2];
		try {
			lockPrinters.lock();
			int tmp = 0;
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
//					ret = i;
					freePrinters[i] = false;
					val[tmp] = i;
					tmp +=1;
					if(tmp == 2){
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		
		return val;
	}

}
