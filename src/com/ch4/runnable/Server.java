package com.ch4.runnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*ThreadPoolExecutor service = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();*/
		ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		System.out.println("Server Started!!!");
		for (int i = 1; i <= 10; i++) {

			Runnable r = new Task("Thread " + i);
			
			/*Thread r = new Thread(new Task("Thread "+i),"Thread "+i);
			int priority = i % 2 == 0 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY;
			r.setPriority(priority);*/
			
			service.execute(r);
			
			System.out
					.printf("Pool Size : %d%n Active Count : %d%n Completed Task : %d%n",
							service.getPoolSize(),
							service.getActiveCount(),
							service.getCompletedTaskCount());

		}		
		//service.shutdownNow();
		service.shutdown();
		System.out.println("Completed Main Thraad!!!");
	}
}
