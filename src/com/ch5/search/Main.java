package com.ch5.search;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

	static void show(List<String> files) {
		for (String s : files)
			System.out.println(s);
	}

	public static void main(String[] args) {

		ForkJoinPool pool = new ForkJoinPool();

		Task t1 = new Task("c:\\Users", "log");
		Task t2 = new Task("c:\\Windows", "log");
		Task t3 = new Task("c:\\Program Files", "log");

		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);

		pool.shutdown();

		/*
		 * try { pool.awaitTermination(1, TimeUnit.DAYS); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// Thread.currentThread().interrupt();

		/*if (t1.isCompletedAbnormally()) {
			System.out.println(t1.getException());
		}*/

		List<String> results = t1.join();
		System.out.printf("%s ::: %d%n", t1, results.size());
		show(results);

		
		/*if (t2.isCompletedAbnormally()) {
			System.out.println(t2.getException());
		}*/
		/*results = t2.join();
		System.out.printf("%s ::: %d%n", t2, results.size());
		show(results);*/

		
		/*if (t3.isCompletedAbnormally()) {
			System.out.println(t3.getException());
		}*/
		/*results = t3.join();
		System.out.printf("%s ::: %d%n", t3, results.size());
		show(results);*/

	}
}
