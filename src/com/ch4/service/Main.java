package com.ch4.service;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args){
		
		ExecutorService exec = Executors.newCachedThreadPool();
		CompletionService<String> service = new ExecutorCompletionService<String>(exec);
		
		Thread c1 = new Thread(new Consumer("Consumer 1",service));
		Thread c2 = new Thread(new Consumer("Consumer 2",service));
		Thread c3 = new Thread(new Consumer("Consumer 3",service));
		Assembler as = new Assembler(service);
		Thread a1 = new Thread(as);
		
		c1.start();
		c2.start();
		c3.start();
		a1.start();
		
		try {
			c1.join();
			c2.join();
			c3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executor is shutting down!!!");
		exec.shutdown();
		
		try {
			exec.awaitTermination(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		as.setEnd(true);
		System.out.println("Main Thread Ends");
		
		
		
		
	}
}
