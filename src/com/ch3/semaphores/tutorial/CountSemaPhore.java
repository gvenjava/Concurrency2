package com.ch3.semaphores.tutorial;

import java.util.concurrent.Semaphore;

public class CountSemaPhore {

	private final Semaphore lock = new Semaphore(1){

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Override
		public void reducePermits(int p) { 
            super.reducePermits(p);
        }
		
	};
	
	private void execute(){
		
		lock.release(); // release happens-before acquire
		lock.release(100);
		
		
		System.out.println(lock.availablePermits());
		
	}
	
	public static void main(String[] args){
		CountSemaPhore obj = new CountSemaPhore();
		obj.execute();
		
	}
	
}
