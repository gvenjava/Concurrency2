package com.ch1.thread.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class TestException {

	public TestException() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(){

			@Override
			public void uncaughtException(Thread t1, Throwable t2) {
				// TODO Auto-generated method stub
				System.out.printf("Thread name : %s, Exception Type %s%n",t1.getName(),t2.getMessage());				
			}		
		});
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				int i = Integer.parseInt("TTT");
				System.out.println(i);
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				int i = Integer.parseInt("YYY");
				System.out.println(i);
			}
		});
		
		/*t1.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){

			@Override
			public void uncaughtException(Thread t1, Throwable t2) {
				// TODO Auto-generated method stub
				System.out.printf("Thread name : %s, Exception Type %s",t1.getName(),t2.getMessage());				
			}		
		});*/
		
		t1.start();
		t2.start();
		
		
	}
	
}
